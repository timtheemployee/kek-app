package kek.foundation.terrorhistory.data.groups

import kek.foundation.terrorhistory.SimpleResponse
import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.domain.repositories.GroupsRepository

class GroupsRepositoryImpl(
    private val api: Api
) : GroupsRepository {

    override fun get(success: (List<Group>) -> Unit,
                     error: (Throwable) -> Unit) {

        api.getGroups().enqueue(
            SimpleResponse<List<Group>>(
                success,
                error
            )
        )
    }
}