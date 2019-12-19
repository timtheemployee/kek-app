package kek.foundation.terrorhistory.domain.repositories

import kek.foundation.terrorhistory.data.events.Event
import kek.foundation.terrorhistory.data.filter.Filter

interface EventsRepository {

    fun get(filter: Filter,
            success: (List<Event>) -> Unit,
            error: (Throwable) -> Unit)
}