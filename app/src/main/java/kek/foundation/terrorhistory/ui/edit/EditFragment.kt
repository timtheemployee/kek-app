package kek.foundation.terrorhistory.ui.edit

import androidx.fragment.app.Fragment
import kek.foundation.terrorhistory.R
import kek.foundation.terrorhistory.ui.BaseFragment

class EditFragment : BaseFragment() {

    companion object {
        fun newInstance(): Fragment = EditFragment()
    }

    override val layout = R.layout.edit_fragment
}