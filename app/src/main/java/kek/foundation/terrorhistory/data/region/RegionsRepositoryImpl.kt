package kek.foundation.terrorhistory.data.region

import kek.foundation.terrorhistory.SimpleResponse
import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.domain.repositories.RegionsRepository

class RegionsRepositoryImpl(
    private val api: Api
): RegionsRepository {

    override fun get(success: (List<Region>) -> Unit, error: (Throwable) -> Unit) {
        api.getRegions().enqueue(
            SimpleResponse<List<Region>>(
                success,
                error
            )
        )
    }
}