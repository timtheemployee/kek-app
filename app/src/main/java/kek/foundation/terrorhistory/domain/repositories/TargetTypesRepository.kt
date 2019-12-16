package kek.foundation.terrorhistory.domain.repositories

import kek.foundation.terrorhistory.data.targettypes.TargetType

interface TargetTypesRepository {

    fun get(success: (List<TargetType>) -> Unit,
            error: (Throwable) -> Unit)
}