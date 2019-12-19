package kek.foundation.terrorhistory.ui.map

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

data class EventItem(val coordinates: LatLng, val group: String, val id: String) : ClusterItem {
    override fun getSnippet(): String = id

    override fun getTitle(): String = group

    override fun getPosition(): LatLng = coordinates
}