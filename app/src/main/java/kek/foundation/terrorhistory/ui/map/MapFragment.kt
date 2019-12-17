package kek.foundation.terrorhistory.ui.map

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mapbox.mapboxsdk.maps.Style
import kek.foundation.terrorhistory.R
import kek.foundation.terrorhistory.ui.BaseFragment
import kotlinx.android.synthetic.main.map_fragment.*

class MapFragment : BaseFragment() {

    companion object {
        fun newInstance(): Fragment = MapFragment()
    }

    override val layout = R.layout.map_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapboxView.onCreate(savedInstanceState)

        mapboxView.getMapAsync { map ->
            map.setStyle(Style.DARK) {

            }
        }
    }
}