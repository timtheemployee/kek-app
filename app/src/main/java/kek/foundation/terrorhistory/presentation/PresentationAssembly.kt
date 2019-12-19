package kek.foundation.terrorhistory.presentation

import kek.foundation.terrorhistory.domain.InteractorAssembly
import kek.foundation.terrorhistory.presentation.filter.FilterPresenter
import kek.foundation.terrorhistory.presentation.map.MapPresenter

class PresentationAssembly (
    private val interactorAssembly: InteractorAssembly
) {

    val filterPresenter: FilterPresenter
        get() = FilterPresenter(
            interactorAssembly.filterInteractor
        )

    val mapPresenter: MapPresenter
        get() = MapPresenter(
            interactorAssembly.mapInteractor
        )
}