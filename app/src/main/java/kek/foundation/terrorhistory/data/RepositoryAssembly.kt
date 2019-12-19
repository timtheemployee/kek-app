package kek.foundation.terrorhistory.data

import kek.foundation.terrorhistory.data.api.ApiAssembly
import kek.foundation.terrorhistory.data.attacktypes.AttackTypeRepositoryImpl
import kek.foundation.terrorhistory.data.countries.CountryRepositoryImpl
import kek.foundation.terrorhistory.data.events.EventsRepositoryImpl
import kek.foundation.terrorhistory.data.filter.FilterRepositoryImpl
import kek.foundation.terrorhistory.data.groups.GroupsRepositoryImpl
import kek.foundation.terrorhistory.data.region.RegionsRepositoryImpl
import kek.foundation.terrorhistory.data.targettypes.TargetTypesRepositoryImpl
import kek.foundation.terrorhistory.domain.repositories.*

class RepositoryAssembly(
    private val apiAssembly: ApiAssembly
) {

    companion object {
        val filterRepository: FilterRepository = FilterRepositoryImpl()
    }

    val eventsRepository: EventsRepository
        get() = EventsRepositoryImpl(apiAssembly.api)

    val attackTypeRepository: AttackTypeRepository
        get() = AttackTypeRepositoryImpl(apiAssembly.api)

    val countryRepository: CountryRepository
        get() = CountryRepositoryImpl(apiAssembly.api)

    val groupsRepository: GroupsRepository
        get() = GroupsRepositoryImpl(apiAssembly.api)

    val regionsRepository: RegionsRepository
        get() = RegionsRepositoryImpl(apiAssembly.api)

    val targetTypesRepository: TargetTypesRepository
        get() = TargetTypesRepositoryImpl(apiAssembly.api)
}