package kek.foundation.terrorhistory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.Mapbox
import kek.foundation.terrorhistory.data.api.ApiAssembly
import kek.foundation.terrorhistory.ui.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this, getString(R.string.map_box_token))

        setContentView(R.layout.main_activity)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, MainFragment.newInstance())
            .commitNow()
    }
}