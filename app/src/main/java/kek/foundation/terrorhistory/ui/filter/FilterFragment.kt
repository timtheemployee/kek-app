package kek.foundation.terrorhistory.ui.filter

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import kek.foundation.terrorhistory.R
import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.data.countries.Country
import kek.foundation.terrorhistory.ui.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilterFragment: BaseFragment() {

    companion object {
        fun newInstance(): Fragment = FilterFragment()
    }

    override val layout = R.layout.filter_fragment
    lateinit var api: Api

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Thread {
            api.getCountries().enqueue(object: Callback<List<Country>> {
                override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                    Log.e("Tag", "${t.printStackTrace()}")
                }

                override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                    Log.e("Tag", "${response.body()}")
                }
            })
        }.start()
    }
}