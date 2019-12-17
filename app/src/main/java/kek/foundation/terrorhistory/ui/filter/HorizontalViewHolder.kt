package kek.foundation.terrorhistory.ui.filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kek.foundation.terrorhistory.R
import kek.foundation.terrorhistory.data.attacktypes.AttackType
import kek.foundation.terrorhistory.data.countries.Country
import kek.foundation.terrorhistory.data.groups.Group
import kek.foundation.terrorhistory.data.region.Region
import kek.foundation.terrorhistory.data.targettypes.TargetType
import kek.foundation.terrorhistory.presentation.filter.*
import kotlinx.android.synthetic.main.horizontal_view_holder.view.*

class HorizontalViewHolder(
    parent: ViewGroup,
    private val onTargetTypeClicked: (TargetType) -> Unit,
    private val onCountryClicked: (Country) -> Unit,
    private val onAttackTypeClicked: (AttackType) -> Unit,
    private val onGroupsClicked: (Group) -> Unit,
    private val onRegionClicked: (Region) -> Unit

): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.horizontal_view_holder, parent, false)
) {

    init {
        itemView.sectorsList.setHasFixedSize(true)
    }

    fun <T> bind(item: T) {
        when(item) {
            is CountriesItem -> bindCountries(item)
            is AttackTypesItem -> bindAttackTypes(item)
            is GroupsItem -> bindGroups(item)
            is RegionsItem -> bindRegions(item)
            is TargetTypesItem -> bindTargetTypes(item)
        }
    }

    private fun bindTargetTypes(item: TargetTypesItem) {
        with(itemView) {
            sectorTitle.text = getText(R.string.target_type)
            sectorsList.adapter = SectorAdapter(
                items = item.targetTypes,
                selectedItems = item.selected,
                onItemClickListener = onTargetTypeClicked
            )
        }
    }

    private fun bindRegions(item: RegionsItem) {
        with(itemView) {
            sectorTitle.text = getText(R.string.regions)
            sectorsList.adapter = SectorAdapter(
                items = item.regions,
                selectedItems = item.selected,
                onItemClickListener = onRegionClicked
            )
        }
    }

    private fun bindCountries(item: CountriesItem) {
        with(itemView) {
            sectorTitle.text = getText(R.string.countries)
            sectorsList.adapter = SectorAdapter(
                items = item.countries,
                selectedItems = item.selected,
                onItemClickListener = onCountryClicked
            )
        }
    }
    
    private fun bindAttackTypes(item: AttackTypesItem) {
        with(itemView) {
            sectorTitle.text = getText(R.string.attack_type)
            sectorsList.adapter = SectorAdapter(
                items = item.attackTypes,
                selectedItems = item.selected,
                onItemClickListener = onAttackTypeClicked
            )
        }
    }
    
    private fun bindGroups(item: GroupsItem) {
        with(itemView) {
            sectorTitle.text = getText(R.string.group)
            sectorsList.adapter = SectorAdapter(
                items = item.groups,
                selectedItems = item.selected,
                onItemClickListener = onGroupsClicked
            )
        }
    }

    private fun View.getText(resId: Int): String =
        context.getString(resId)
}