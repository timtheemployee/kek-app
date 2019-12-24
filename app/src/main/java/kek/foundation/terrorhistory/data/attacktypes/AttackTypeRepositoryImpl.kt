package kek.foundation.terrorhistory.data.attacktypes

import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.data.trace.TraceCallback
import kek.foundation.terrorhistory.domain.repositories.AttackTypeRepository

class AttackTypeRepositoryImpl(
    private val api: Api,
    private val traceCallback: TraceCallback<List<AttackType>>
) : AttackTypeRepository {

    override fun get(success: (List<AttackType>) -> Unit,
                     error: (Throwable) -> Unit) {

        api.getAttackTypes().enqueue(
            traceCallback.apply {
                this.success = success
                this.error = error
            }
        )
    }
}