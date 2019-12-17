package kek.foundation.terrorhistory.ui.filter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kek.foundation.terrorhistory.data.attacktypes.AttackType
import kek.foundation.terrorhistory.data.countries.Country
import kek.foundation.terrorhistory.data.groups.Group
import kek.foundation.terrorhistory.data.region.Region
import kek.foundation.terrorhistory.data.targettypes.TargetType
import kek.foundation.terrorhistory.presentation.filter.*

class FilterAdapter(
    private val onCountryClicked: (Country) -> Unit,
    private val onRegionClicked: (Region) -> Unit,
    private val onGroupClicked: (Group) -> Unit,
    private val onAttackTypeClicked: (AttackType) -> Unit,
    private val onTargetTypeClicked: (TargetType) -> Unit
) : RecyclerView.Adapter<HorizontalViewHolder>() {

    var items = listOf<FilterItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder =
        HorizontalViewHolder(
            parent = parent,
            onTargetTypeClicked = onTargetTypeClicked,
            onCountryClicked = onCountryClicked,
            onRegionClicked = onRegionClicked,
            onAttackTypeClicked = onAttackTypeClicked,
            onGroupsClicked = onGroupClicked
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }


}