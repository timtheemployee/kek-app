package kek.foundation.terrorhistory.domain.repositories

import kek.foundation.terrorhistory.data.countries.Country

interface CountryRepository {

    fun get(success: (List<Country>) -> Unit,
            error: (Throwable) -> Unit)
}