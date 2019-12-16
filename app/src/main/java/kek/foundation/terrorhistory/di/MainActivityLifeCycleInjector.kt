package kek.foundation.terrorhistory.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kek.foundation.terrorhistory.data.api.ApiAssembly
import kek.foundation.terrorhistory.presentation.PresentationAssembly

class MainActivityLifeCycleInjector(
    presentationAssembly: PresentationAssembly
) : Application.ActivityLifecycleCallbacks {

    private val filterInjector = FragmentLifecycleInjector(presentationAssembly.filterPresenter)

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStarted(activity: Activity) {
        (activity as AppCompatActivity)
            .supportFragmentManager
            .registerFragmentLifecycleCallbacks(
                filterInjector,
                true
            )
    }

    override fun onActivityDestroyed(activity: Activity) {
        (activity as AppCompatActivity)
            .supportFragmentManager
            .unregisterFragmentLifecycleCallbacks(
                filterInjector
            )
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    }

    override fun onActivityResumed(activity: Activity) {
    }
}