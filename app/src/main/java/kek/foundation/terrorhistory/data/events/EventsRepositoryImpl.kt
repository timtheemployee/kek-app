package kek.foundation.terrorhistory.data.events

import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.data.filter.Filter
import kek.foundation.terrorhistory.data.trace.TraceCallback
import kek.foundation.terrorhistory.domain.repositories.EventsRepository

class EventsRepositoryImpl(
    private val api: Api,
    private val traceCallback: TraceCallback<List<Event>>
): EventsRepository {


    override fun get(filter: Filter,
                     success: (List<Event>) -> Unit,
                     error: (Throwable) -> Unit) {

        api.getFilteredEvents(filter).enqueue(
            traceCallback.apply {
                this.success = success
                this.error = error
            }
        )

    }

}