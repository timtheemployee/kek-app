package kek.foundation.terrorhistory.data.events

import kek.foundation.terrorhistory.SimpleResponse
import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.data.filter.Filter
import kek.foundation.terrorhistory.domain.repositories.EventsRepository

class EventsRepositoryImpl(private val api: Api): EventsRepository {


    override fun get(filter: Filter,
                     success: (List<Event>) -> Unit,
                     error: (Throwable) -> Unit) {

        api.getFilteredEvents(filter).enqueue(
            SimpleResponse<List<Event>>(
                success,
                error
            )
        )

    }

}