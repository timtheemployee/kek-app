package kek.foundation.terrorhistory.data

import kek.foundation.terrorhistory.data.api.ApiAssembly
import kek.foundation.terrorhistory.data.attacktypes.AttackTypeRepositoryImpl
import kek.foundation.terrorhistory.data.countries.CountryRepositoryImpl
import kek.foundation.terrorhistory.data.events.EventsRepositoryImpl
import kek.foundation.terrorhistory.data.filter.FilterRepositoryImpl
import kek.foundation.terrorhistory.data.groups.GroupsRepositoryImpl
import kek.foundation.terrorhistory.data.region.RegionsRepositoryImpl
import kek.foundation.terrorhistory.data.targettypes.TargetTypesRepositoryImpl
import kek.foundation.terrorhistory.data.trace.TraceCallbackAssembly
import kek.foundation.terrorhistory.data.trace.TraceRequest
import kek.foundation.terrorhistory.domain.repositories.*

class RepositoryAssembly(
    private val apiAssembly: ApiAssembly,
    private val traceCallbackAssembly: TraceCallbackAssembly
) {

    companion object {
        val filterRepository: FilterRepository = FilterRepositoryImpl()
    }

    val eventsRepository: EventsRepository
        get() = EventsRepositoryImpl(apiAssembly.api, traceCallbackAssembly.make(TraceRequest.EVENTS))

    val attackTypeRepository: AttackTypeRepository
        get() = AttackTypeRepositoryImpl(apiAssembly.api, traceCallbackAssembly.make(TraceRequest.ATTACK_TYPES))

    val countryRepository: CountryRepository
        get() = CountryRepositoryImpl(apiAssembly.api, traceCallbackAssembly.make(TraceRequest.COUNTRIES))

    val groupsRepository: GroupsRepository
        get() = GroupsRepositoryImpl(apiAssembly.api, traceCallbackAssembly.make(TraceRequest.GROUPS))

    val regionsRepository: RegionsRepository
        get() = RegionsRepositoryImpl(apiAssembly.api, traceCallbackAssembly.make(TraceRequest.REGION))

    val targetTypesRepository: TargetTypesRepository
        get() = TargetTypesRepositoryImpl(apiAssembly.api, traceCallbackAssembly.make(TraceRequest.TARGET_TYPE))
}