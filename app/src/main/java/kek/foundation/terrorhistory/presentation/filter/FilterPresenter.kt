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

}

class FilterPresenter(
    private val interactor: FilterInteractor
) : BasePresenter<FilterView>() {

    private var filterItems = arrayListOf<FilterItem>()
    private var filter = Filter()

    override fun onFirstViewAttach() {
        Log.e("TAG", "Called On First View Attach $this")

        filterItems.clear()

        interactor.getRegions(
            success = {
                filterItems.add(RegionsItem(it))
                view?.updateFiltersList(filterItems)
            },
            error = {}
        )

        interactor.getCountries(
            success = {
                filterItems.add(CountriesItem(it))
                view?.updateFiltersList(filterItems)
            },
            error = { /*do nothing */ })

        interactor.getAttackTypes(
            success = {
                filterItems.add(AttackTypesItem(it))
                view?.updateFiltersList(filterItems)
            },
            error = { }
        )

        interactor.getGroups(
            success = {
                filterItems.add(GroupsItem(it))
                view?.updateFiltersList(filterItems)
            },
            error = {}
        )

        interactor.getTargetTypes(
            success = {
                filterItems.add(TargetTypesItem(it))
                view?.updateFiltersList(filterItems)
            },
            error = {}
        )
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