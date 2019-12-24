package kek.foundation.terrorhistory.data.targettypes

import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.data.trace.TraceCallback
import kek.foundation.terrorhistory.domain.repositories.TargetTypesRepository

class TargetTypesRepositoryImpl(
    private val api: Api,
    private val traceCallback: TraceCallback<List<TargetType>>
): TargetTypesRepository {

    override fun get(success: (List<TargetType>) -> Unit,
                     error: (Throwable) -> Unit) {

        api.getTargetTypes().enqueue(
            traceCallback.apply {
                this.success = success
                this.error = error
            }
        )
    }
}