package kek.foundation.terrorhistory

import android.app.Application
import kek.foundation.terrorhistory.data.api.ApiAssembly
import kek.foundation.terrorhistory.di.MainActivityLifeCycleInjector

class App : Application() {

    private val apiAssembly = ApiAssembly(endPoint = "http://kek-backend.herokuapp.com")
    private val activityInjector = MainActivityLifeCycleInjector(apiAssembly)

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(activityInjector)
    }


}