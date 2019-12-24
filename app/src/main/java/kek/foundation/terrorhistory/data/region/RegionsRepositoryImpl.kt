package kek.foundation.terrorhistory.data.region

import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.data.trace.TraceCallback
import kek.foundation.terrorhistory.domain.repositories.RegionsRepository

class RegionsRepositoryImpl(
    private val api: Api,
    private val traceCallback: TraceCallback<List<Region>>
): RegionsRepository {

    override fun get(success: (List<Region>) -> Unit, error: (Throwable) -> Unit) {
        api.getRegions().enqueue(
           traceCallback.apply {
               this.success = success
               this.error = error
           }
        )
    }
}