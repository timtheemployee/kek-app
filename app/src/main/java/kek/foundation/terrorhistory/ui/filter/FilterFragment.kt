package kek.foundation.terrorhistory.ui.filter

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import kek.foundation.terrorhistory.R
import kek.foundation.terrorhistory.data.api.Api
import kek.foundation.terrorhistory.data.countries.Country
import kek.foundation.terrorhistory.presentation.filter.FilterItem
import kek.foundation.terrorhistory.presentation.filter.FilterPresenter
import kek.foundation.terrorhistory.presentation.filter.FilterView
import kek.foundation.terrorhistory.ui.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilterFragment: BaseFragment(), FilterView {

    companion object {
        fun newInstance(): Fragment = FilterFragment()
    }

    override val layout = R.layout.filter_fragment

    lateinit var presenter: FilterPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
    }

    override fun updateFiltersList(items: List<FilterItem>) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}