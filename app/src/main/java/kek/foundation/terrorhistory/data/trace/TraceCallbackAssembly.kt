package kek.foundation.terrorhistory.data.trace

import kek.foundation.terrorhistory.data.api.TraceApi

class TraceCallbackAssembly(
    private val traceApi: TraceApi
) {

    fun <T> make(type: TraceRequest): TraceCallback<T> =
        TraceCallback(type, traceApi)
}