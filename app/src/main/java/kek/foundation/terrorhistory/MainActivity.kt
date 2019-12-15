package kek.foundation.terrorhistory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kek.foundation.terrorhistory.data.api.ApiAssembly
import kek.foundation.terrorhistory.ui.MainFragment

class MainActivity : AppCompatActivity() {

    private val apiAssembly = ApiAssembly(endPoint = "kek-backend.herokuapp.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, MainFragment.newInstance())
            .commitNow()
    }
}