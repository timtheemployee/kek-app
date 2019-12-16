package kek.foundation.terrorhistory.domain.repositories

import kek.foundation.terrorhistory.data.attacktypes.AttackType

interface AttackTypeRepository {

    fun get(success: (List<AttackType>) -> Unit,
            error: (Throwable) -> Unit)
}