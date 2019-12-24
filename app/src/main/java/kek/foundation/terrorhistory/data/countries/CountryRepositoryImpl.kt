package kek.foundation.terrorhistory.data.countries

import kek.foundation.terrorhistory.SimpleResponse
import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.data.trace.TraceCallback
import kek.foundation.terrorhistory.domain.repositories.CountryRepository

class CountryRepositoryImpl(
    private val api: Api,
    private val traceCallback: TraceCallback<List<Country>>
) : CountryRepository {
    override fun get(success: (List<Country>) -> Unit, error: (Throwable) -> Unit) {

        api
            .getCountries()
            .enqueue(
                traceCallback.apply {
                    this.success = success
                    this.error = error
                }
            )
    }
}