package kek.foundation.terrorhistory.data.api

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class ApiAssembly(private val endPoint: String) {

    val api: Api
        get() =
            createApi(
                url = endPoint,
                client = createHttpClient(interceptor = createLoggingInterceptor()),
                converterFactory = createGsonConverterFactory(gson = createGson()),
                executor = createExecutor(),
                api = Api::class.java
            )


    private fun createExecutor(): Executor =
        Executors.newCachedThreadPool()

    private fun createGson(): Gson =
        Gson()

    private fun createGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    private fun createLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }

    private fun createHttpClient(interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(10000, TimeUnit.MILLISECONDS)
            .readTimeout(10000, TimeUnit.MILLISECONDS)
            .addInterceptor(interceptor)
            .build()

    private fun <T> createApi(
        url: String,
        client: OkHttpClient,
        converterFactory: GsonConverterFactory,
        executor: Executor,
        api: Class<T>
    ): T =
        Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(converterFactory)
            .callbackExecutor(executor)
            .build()
            .create(api)
}