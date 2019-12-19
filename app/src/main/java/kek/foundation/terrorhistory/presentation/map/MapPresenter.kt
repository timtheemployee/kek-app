package kek.foundation.terrorhistory.presentation.map

import kek.foundation.terrorhistory.data.events.Event
import kek.foundation.terrorhistory.domain.map.MapInteractor
import kek.foundation.terrorhistory.presentation.BasePresenter
import kek.foundation.terrorhistory.ui.BaseView

interface FilterMapView: BaseView {

    fun updateEvents(events: List<Event>)
    fun showLoadingError()
    fun showEvent(target: Event)
}

class MapPresenter(
    private val mapInteractor: MapInteractor
): BasePresenter<FilterMapView>() {

    private val events = arrayListOf<Event>()

    override fun onFirstViewAttach() {

        mapInteractor.getEvents(success = {
            view?.updateEvents(it)
            events.clear()
            events.addAll(it)
        }, error = {
            view?.showLoadingError()
        })
    }

    fun onMarkerClicked(marker: Any?) {
        marker?.let {
           val event =  events.firstOrNull { it.eventId == marker }

            event?.let { target ->
                view?.showEvent(target)
            }
        }
    }
}