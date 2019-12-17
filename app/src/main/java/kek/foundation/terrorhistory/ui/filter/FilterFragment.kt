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
import kotlinx.android.synthetic.main.filter_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilterFragment: BaseFragment(), FilterView {

    companion object {
        fun newInstance(): Fragment = FilterFragment()
    }

    override val layout = R.layout.filter_fragment

    lateinit var presenter: FilterPresenter
    private lateinit var filterAdapter: FilterAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filterAdapter = FilterAdapter(
            onCountryClicked = presenter::onCountryClicked,
            onRegionClicked = presenter::onRegionClicked,
            onGroupClicked = presenter::onGroupClicked,
            onTargetTypeClicked = presenter::onTargetTypeClicked,
            onAttackTypeClicked = presenter::onAttackTypeClicked
        )

        filterList.adapter = filterAdapter

        presenter.attachView(this)
    }

    override fun updateFiltersList(items: List<FilterItem>) {
        requireActivity().runOnUiThread {
            Log.e("TAG","ITEMS SIZE -> ${items.size}")
            filterAdapter.items = items
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.saveFilter()
        presenter.detachView()
    }
}