package kek.foundation.terrorhistory

import android.app.Application
import kek.foundation.terrorhistory.data.RepositoryAssembly
import kek.foundation.terrorhistory.data.api.ApiAssembly
import kek.foundation.terrorhistory.di.MainActivityLifeCycleInjector
import kek.foundation.terrorhistory.domain.InteractorAssembly
import kek.foundation.terrorhistory.presentation.PresentationAssembly

class App : Application() {

    private val apiAssembly = ApiAssembly(endPoint = "http://kek-backend.herokuapp.com")
    private val repositoryAssembly = RepositoryAssembly(apiAssembly = apiAssembly)
    private val interactorsAssembly = InteractorAssembly(repositoryAssembly)
    private val presentationAssembly = PresentationAssembly(interactorsAssembly)
    private val activityInjector = MainActivityLifeCycleInjector(presentationAssembly)

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(activityInjector)
    }


}