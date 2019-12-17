package kek.foundation.terrorhistory.data.filter

data class Filter(
    val minYear: Int? = null,
    val maxYear: Int? = null,
    val isExtended: Boolean? = null,
    val countries: List<Long>? = null,
    val regions: List<Long>? = null,
    val isSuccess: Boolean? = null,
    val isSuicide: Boolean? = null,
    val attackTypes: List<Long>? = null,
    val targetTypes: List<Long>? = null,
    val groups: List<Long>? = null
)