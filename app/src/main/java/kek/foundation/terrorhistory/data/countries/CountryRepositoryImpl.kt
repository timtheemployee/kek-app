package kek.foundation.terrorhistory.data.countries

import kek.foundation.terrorhistory.SimpleResponse
import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.domain.repositories.CountryRepository

class CountryRepositoryImpl(
    private val api: Api
) : CountryRepository {
    override fun get(success: (List<Country>) -> Unit, error: (Throwable) -> Unit) {

        api
            .getCountries()
            .enqueue(
                SimpleResponse<List<Country>>(success, error)
            )
    }
}