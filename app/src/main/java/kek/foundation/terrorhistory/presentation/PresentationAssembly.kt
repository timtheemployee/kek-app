package kek.foundation.terrorhistory.presentation

import kek.foundation.terrorhistory.domain.InteractorAssembly
import kek.foundation.terrorhistory.presentation.filter.FilterPresenter

class PresentationAssembly (
    private val interactorAssembly: InteractorAssembly
) {

    val filterPresenter: FilterPresenter
        get() = FilterPresenter(
            interactorAssembly.filterInteractor
        )
}