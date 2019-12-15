package kek.foundation.terrorhistory.data.api

import kek.foundation.terrorhistory.data.countries.Country
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/countries")
    fun getCountries(): Call<List<Country>>
}