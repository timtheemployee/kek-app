package kek.foundation.terrorhistory.domain.repositories

import kek.foundation.terrorhistory.data.groups.Group

interface GroupsRepository {

    fun get(success: (List<Group>) -> Unit,
            error: (Throwable) -> Unit)
}