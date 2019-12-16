package kek.foundation.terrorhistory.data.targettypes

import kek.foundation.terrorhistory.SimpleResponse
import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.domain.repositories.TargetTypesRepository

class TargetTypesRepositoryImpl(
    private val api: Api
): TargetTypesRepository {

    override fun get(success: (List<TargetType>) -> Unit,
                     error: (Throwable) -> Unit) {

        api.getTargetTypes().enqueue(
            SimpleResponse<List<TargetType>>(
                success,
                error
            )
        )
    }
}