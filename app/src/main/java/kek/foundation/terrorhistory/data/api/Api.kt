package kek.foundation.terrorhistory.data.api

import kek.foundation.terrorhistory.data.attacktypes.AttackType
import kek.foundation.terrorhistory.data.countries.Country
import kek.foundation.terrorhistory.data.events.Event
import kek.foundation.terrorhistory.data.filter.Filter
import kek.foundation.terrorhistory.data.groups.Group
import kek.foundation.terrorhistory.data.region.Region
import kek.foundation.terrorhistory.data.targettypes.TargetType
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("/countries")
    fun getCountries(): Call<List<Country>>

    @GET("/attack-types")
    fun getAttackTypes(): Call<List<AttackType>>

    @GET("/groups")
    fun getGroups(): Call<List<Group>>

    @GET("/regions")
    fun getRegions(): Call<List<Region>>

    @GET("/target-types")
    fun getTargetTypes(): Call<List<TargetType>>

    @POST("/filterBy")
    fun getFilteredEvents(@Body filter: Filter): Call<List<Event>>
}