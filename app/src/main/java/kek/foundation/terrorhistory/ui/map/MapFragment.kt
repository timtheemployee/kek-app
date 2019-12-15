package kek.foundation.terrorhistory.ui.map

import androidx.fragment.app.Fragment
import kek.foundation.terrorhistory.R
import kek.foundation.terrorhistory.ui.BaseFragment

class MapFragment: BaseFragment() {

    companion object {
        fun newInstance(): Fragment = MapFragment()
    }

    override val layout = R.layout.map_fragment
}