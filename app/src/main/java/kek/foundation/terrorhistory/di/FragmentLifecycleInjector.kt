package kek.foundation.terrorhistory.di

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kek.foundation.terrorhistory.presentation.PresentationAssembly
import kek.foundation.terrorhistory.presentation.filter.FilterPresenter
import kek.foundation.terrorhistory.presentation.map.MapPresenter
import kek.foundation.terrorhistory.ui.filter.FilterFragment
import kek.foundation.terrorhistory.ui.map.MapFragment

class FragmentLifecycleInjector(private val presentationAssembly: PresentationAssembly) : FragmentManager.FragmentLifecycleCallbacks() {

    override fun onFragmentPreAttached(fm: FragmentManager, fragment: Fragment, context: Context) {
        super.onFragmentPreAttached(fm, fragment, context)

        when(fragment) {
            is FilterFragment -> fragment.presenter = presentationAssembly.filterPresenter
            is MapFragment -> fragment.presenter = presentationAssembly.mapPresenter
        }
    }
}