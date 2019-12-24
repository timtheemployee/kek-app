package kek.foundation.terrorhistory.data.groups

import kek.foundation.terrorhistory.SimpleResponse
import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.data.trace.TraceCallback
import kek.foundation.terrorhistory.domain.repositories.GroupsRepository

class GroupsRepositoryImpl(
    private val api: Api,
    private val traceCallback: TraceCallback<List<Group>>
) : GroupsRepository {

    override fun get(success: (List<Group>) -> Unit,
                     error: (Throwable) -> Unit) {

        api.getGroups().enqueue(
            traceCallback.apply {
                this.success = success
                this.error = error
            }
        )
    }
}