package kek.foundation.terrorhistory.data.attacktypes

import kek.foundation.terrorhistory.SimpleResponse
import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.domain.repositories.AttackTypeRepository

class AttackTypeRepositoryImpl(
    private val api: Api
) : AttackTypeRepository {

    override fun get(success: (List<AttackType>) -> Unit,
                     error: (Throwable) -> Unit) {

        api.getAttackTypes().enqueue(
            SimpleResponse<List<AttackType>>(
                success,
                error
            )
        )
    }
}