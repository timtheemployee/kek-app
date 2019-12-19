package kek.foundation.terrorhistory.domain.map

import kek.foundation.terrorhistory.data.events.Event
import kek.foundation.terrorhistory.domain.repositories.EventsRepository
import kek.foundation.terrorhistory.domain.repositories.FilterRepository

class MapInteractor(
    private val filterRepository: FilterRepository,
    private val eventsRepository: EventsRepository
) {

    fun getEvents(success: (List<Event>) -> Unit,
                  error: (Throwable) -> Unit) {

        eventsRepository.get(
            filterRepository.filter,
            success,
            error
        )
    }
}