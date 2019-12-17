package kek.foundation.terrorhistory.data.filter

import kek.foundation.terrorhistory.domain.repositories.FilterRepository

class FilterRepositoryImpl: FilterRepository {
    override var filter: Filter = Filter()
}