package kek.foundation.terrorhistory.presentation.filter

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
        set(value) {
            field = value
            view?.updateFiltersList(value)
        }

    override fun onFirstViewAttach() {
        interactor.getRegions(
            success = { filterItems.add(RegionsItem(it)) },
            error = {}
        )

        interactor.getCountries(
            success = { filterItems.add(CountriesItem(it)) },
            error = { /*do nothing */ })

        interactor.getAttackTypes(
            success = { filterItems.add(AttackTypesItem(it)) },
            error = { }
        )

        interactor.getGroups(
            success = { filterItems.add(GroupsItem(it))},
            error = {}
        )

        interactor.getTargetTypes(
            success = { filterItems.add(TargetTypesItem(it)) },
            error = {}
        )
    }
}