package kek.foundation.terrorhistory.domain

import kek.foundation.terrorhistory.data.RepositoryAssembly
import kek.foundation.terrorhistory.domain.filter.FilterInteractor

class InteractorAssembly(
    private val repositoryAssembly: RepositoryAssembly
) {

    val filterInteractor: FilterInteractor
        get() = FilterInteractor(
            repositoryAssembly.countryRepository,
            repositoryAssembly.attackTypeRepository,
            repositoryAssembly.groupsRepository,
            repositoryAssembly.regionsRepository,
            repositoryAssembly.targetTypesRepository,
            RepositoryAssembly.filterRepository
        )
}