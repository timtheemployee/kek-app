package kek.foundation.terrorhistory.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kek.foundation.terrorhistory.R
import kek.foundation.terrorhistory.ui.edit.EditFragment
import kek.foundation.terrorhistory.ui.filter.FilterFragment
import kek.foundation.terrorhistory.ui.map.MapFragment
import kotlinx.android.synthetic.main.main_fragment.*
import java.lang.IllegalArgumentException

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance(): Fragment = MainFragment()
    }

    override val layout = R.layout.main_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showFilter()

        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.filter -> {
                    showFilter()
                    true
                }

                R.id.map -> {
                    showMap()
                    true
                }

                R.id.edit -> {
                    showEdit()
                    true
                }

                else -> false
            }

        }
    }

    private fun showFilter() {
        toolbar.title = getString(R.string.filter)
        showFragment(FilterFragment.newInstance())
    }

    private fun showMap() {
        toolbar.title = getString(R.string.map)
        showFragment(MapFragment.newInstance())
    }

    private fun showEdit() {
        toolbar.title = getString(R.string.edit)
        showFragment(EditFragment.newInstance())
    }

    private fun Fragment.showFragment(fragment: Fragment) {
        childFragmentManager
            .beginTransaction()
            .replace(R.id.contentLayout, fragment, getTag(fragment))
            .commitNow()
    }

    private fun getTag(fragment: Fragment): String =
        when (fragment) {
            is FilterFragment -> "FilterFragment"
            is MapFragment -> "MapFragment"
            is EditFragment -> "EditFragment"
            else -> throw IllegalArgumentException("This fragment is not on bottom navigation bar")
        }
}