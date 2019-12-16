package kek.foundation.terrorhistory.di

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kek.foundation.terrorhistory.presentation.filter.FilterPresenter
import kek.foundation.terrorhistory.ui.filter.FilterFragment

class FragmentLifecycleInjector(private val filterPresenter: FilterPresenter) : FragmentManager.FragmentLifecycleCallbacks() {

    override fun onFragmentPreAttached(fm: FragmentManager, fragment: Fragment, context: Context) {
        super.onFragmentPreAttached(fm, fragment, context)

        when(fragment) {
            is FilterFragment -> fragment.presenter = filterPresenter
        }
    }
}