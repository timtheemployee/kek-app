package kek.foundation.terrorhistory.data.filter

data class Filter(
    val minYear: Int? = null,
    val maxYear: Int? = null,
    val isExtended: Boolean? = null,
    val countries: List<Int>? = null,
    val regions: List<Int>? = null,
    val isSuccess: Boolean? = null,
    val isSuicide: Boolean? = null,
    val attackTypes: List<Int>? = null,
    val targetTypes: List<Int>? = null,
    val groups: List<Int>? = null
)