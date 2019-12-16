package kek.foundation.terrorhistory.domain.filter

import kek.foundation.terrorhistory.data.attacktypes.AttackType
import kek.foundation.terrorhistory.data.countries.Country
import kek.foundation.terrorhistory.data.groups.Group
import kek.foundation.terrorhistory.data.region.Region
import kek.foundation.terrorhistory.data.targettypes.TargetType
import kek.foundation.terrorhistory.domain.repositories.*

class FilterInteractor(
    private val countryRepository: CountryRepository,
    private val attackTypeRepository: AttackTypeRepository,
    private val groupsRepository: GroupsRepository,
    private val regionsRepository: RegionsRepository,
    private val targetTypesRepository: TargetTypesRepository
) {

    fun getCountries(success: (List<Country>) -> Unit,
                     error: (Throwable) -> Unit) {

        countryRepository.get(
            success,
            error
        )
    }

    fun getAttackTypes(success: (List<AttackType>) -> Unit,
                       error: (Throwable) -> Unit) {

        attackTypeRepository.get(
            success,
            error
        )
    }

    fun getGroups(success: (List<Group>) -> Unit,
                  error: (Throwable) -> Unit) {

        groupsRepository.get(
            success,
            error
        )
    }

    fun getRegions(success: (List<Region>) -> Unit,
                   error: (Throwable) -> Unit) {

        regionsRepository.get(
            success,
            error
        )
    }

    fun getTargetTypes(success: (List<TargetType>) -> Unit,
                       error: (Throwable) -> Unit) {

        targetTypesRepository.get(
            success,
            error
        )
    }
}