package kek.foundation.terrorhistory.ui.filter

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kek.foundation.terrorhistory.R
import kek.foundation.terrorhistory.presentation.filter.FilterItem
import kek.foundation.terrorhistory.presentation.filter.FilterPresenter
import kek.foundation.terrorhistory.presentation.filter.FilterView
import kek.foundation.terrorhistory.ui.BaseFragment
import kotlinx.android.synthetic.main.filter_fragment.*

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
            progress.isVisible = false
            filterAdapter.items = items
        }
    }

    override fun showLoadingError(message: String?) {
        progress.isVisible = false
        Snackbar.make(filterList, "Произошла ошибка, $message", Snackbar.LENGTH_LONG)
            .setAction("Повторить") {
                presenter.onFirstViewAttach()
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.saveFilter()
        presenter.detachView()
    }
}