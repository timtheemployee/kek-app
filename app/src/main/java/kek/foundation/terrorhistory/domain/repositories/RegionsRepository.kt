package kek.foundation.terrorhistory.domain.repositories

import kek.foundation.terrorhistory.data.region.Region

interface RegionsRepository {

    fun get(success: (List<Region>) -> Unit,
            error: (Throwable) -> Unit)
}