package kek.foundation.terrorhistory.presentation.filter

import android.util.Log
import kek.foundation.terrorhistory.data.attacktypes.AttackType
import kek.foundation.terrorhistory.data.countries.Country
import kek.foundation.terrorhistory.data.filter.Filter
import kek.foundation.terrorhistory.data.groups.Group
import kek.foundation.terrorhistory.data.region.Region
import kek.foundation.terrorhistory.data.targettypes.TargetType
import kek.foundation.terrorhistory.domain.filter.FilterInteractor
import kek.foundation.terrorhistory.presentation.BasePresenter
import kek.foundation.terrorhistory.ui.BaseView

interface FilterView : BaseView {

    fun updateFiltersList(items: List<FilterItem>)
    fun showLoadingError(message: String?)

}

class FilterPresenter(
    private val interactor: FilterInteractor
) : BasePresenter<FilterView>() {

    private var filterItems = arrayListOf<FilterItem>()
    private var filter = Filter()

    override fun onFirstViewAttach() {
        filterItems.clear()

        interactor.getRegions(
            success = { onListLoaded(RegionsItem(it)) },
            error = ::showLoadingError
        )

        interactor.getCountries(
            success = { onListLoaded(CountriesItem(it)) },
            error = ::showLoadingError
        )

        interactor.getAttackTypes(
            success = { onListLoaded(AttackTypesItem(it)) },
            error = ::showLoadingError
        )

        interactor.getGroups(
            success = { onListLoaded(GroupsItem(it)) },
            error = ::showLoadingError
        )

        interactor.getTargetTypes(
            success = { onListLoaded(TargetTypesItem(it)) },
            error = ::showLoadingError
        )
    }

    private fun onListLoaded(item: FilterItem) {
        filterItems.add(item)
        view?.updateFiltersList(filterItems)
    }

    private fun showLoadingError(throwable: Throwable) {
        view?.showLoadingError(throwable.message)
    }

    fun onCountryClicked(country: Country) {
        val countriesItem = filterItems.first { it is CountriesItem } as CountriesItem

        countriesItem.selected.apply {
            add(country)

            val list = toList()
                .map { it.id }

            if(list.isNotEmpty()) {
                filter = filter.copy(countries = list)
            }
        }

        view?.updateFiltersList(filterItems)
    }

    fun onRegionClicked(region: Region) {
        val regionsItem = filterItems.first { it is RegionsItem } as RegionsItem
        regionsItem.selected.apply {
            add(region)

            val list = toList()
                .map { it.id }

            if(list.isNotEmpty()) {
                filter = filter.copy(regions = list)
            }
        }
        view?.updateFiltersList(filterItems)
    }

    fun onGroupClicked(group: Group) {
        val groupsItem = filterItems.first{ it is GroupsItem } as GroupsItem
        groupsItem.selected.apply {
            add(group)

            val list = toList()
                .map { it.id }

            if(list.isNotEmpty()) {
                filter = filter.copy(groups = list)
            }
        }
        view?.updateFiltersList(filterItems)
    }

    fun onTargetTypeClicked(targetType: TargetType) {
        val targetTypesItem = filterItems.first { it is TargetTypesItem } as TargetTypesItem
        targetTypesItem.selected.apply {
            add(targetType)

            val list = toList()
                .map { it.id }

            if(list.isNotEmpty()) {
                filter = filter.copy(groups = list)
            }
        }
        view?.updateFiltersList(filterItems)
    }

    fun onAttackTypeClicked(attackType: AttackType) {
        val attackTypesItem = filterItems.first { it is AttackTypesItem } as AttackTypesItem
        attackTypesItem.selected.apply {
            add(attackType)

            val list = toList()
                .map { it.id }

            if(list.isNotEmpty()) {
                filter = filter.copy(attackTypes = list)
            }
        }


        view?.updateFiltersList(filterItems)
    }

    fun saveFilter() {
        interactor.updateFilter(filter)
    }

}