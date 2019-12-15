package kek.foundation.terrorhistory.data.api

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiAssembly(private val endPoint: String) {

    val api: Api
        get() =
            createApi(
                url = endPoint,
                client = createHttpClient(interceptor = createLoggingInterceptor()),
                converterFactory = createGsonConverterFactory(gson = createGson()),
                api = Api::class.java
            )


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
            .addInterceptor(interceptor)
            .build()

    private fun <T> createApi(
        url: String,
        client: OkHttpClient,
        converterFactory: GsonConverterFactory,
        api: Class<T>
    ): T =
        Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(converterFactory)
            .build()
            .create(api)
}