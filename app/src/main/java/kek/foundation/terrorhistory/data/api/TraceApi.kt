package kek.foundation.terrorhistory.data.api

import kek.foundation.terrorhistory.data.trace.Trace
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface TraceApi {

    @POST("/traceEvent")
    fun logRequest(@Body trace: Trace): Call<ResponseBody>
}