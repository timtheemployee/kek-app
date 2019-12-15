package kek.foundation.terrorhistory.di

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.ui.filter.FilterFragment

class FilterFragmentLifecycleInjector(private val api: Api) : FragmentManager.FragmentLifecycleCallbacks() {

    override fun onFragmentPreAttached(fm: FragmentManager, fragment: Fragment, context: Context) {
        super.onFragmentPreAttached(fm, fragment, context)

        (fragment as FilterFragment).api = api
    }
}