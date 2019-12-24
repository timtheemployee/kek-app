package kek.foundation.terrorhistory.data.trace

import android.os.Build
import kek.foundation.terrorhistory.SimpleResponse
import kek.foundation.terrorhistory.data.api.TraceApi
import kek.foundation.terrorhistory.data.trace.TraceRequest.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalArgumentException

class TraceCallback<T>(
    private val requestType: TraceRequest,
    private val traceApi: TraceApi
) : Callback<T> {

    var success: ((T) -> Unit)? = null
    var error: ((Throwable) -> Unit)? = null

    override fun onFailure(call: Call<T>, t: Throwable) {
        traceApi.logRequest(
            makeTrace(0)
        ).enqueue(SimpleResponse<ResponseBody>())

        error?.invoke(t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        val body = response.body()
        if(response.isSuccessful && body != null) {
            success?.invoke(body)
        } else {
            error?.invoke(IllegalArgumentException("Response with code ${response.code()}"))
        }

        traceApi.logRequest(makeTrace(response.code())).enqueue(SimpleResponse<ResponseBody>())
    }

    private fun makeTrace(statusCode: Int): Trace =
        Trace(getDeviceName(),
            getRequest(requestType),
            statusCode)

    private fun getDeviceName(): String = Build.MODEL

    private fun getRequest(requestType: TraceRequest) =
        "http://kek-backend.herokuapp.com" + when (requestType) {
            ATTACK_TYPES -> "/attack-types"
            COUNTRIES -> "/countries"
            EVENTS -> "/filterBy"
            GROUPS -> "/groups"
            REGION -> "/regions"
            TARGET_TYPE -> "/target-types"
        }
}