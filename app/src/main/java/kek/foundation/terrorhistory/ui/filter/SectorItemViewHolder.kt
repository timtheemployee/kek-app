package kek.foundation.terrorhistory.ui.filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kek.foundation.terrorhistory.R
import kek.foundation.terrorhistory.data.attacktypes.AttackType
import kek.foundation.terrorhistory.data.countries.Country
import kek.foundation.terrorhistory.data.groups.Group
import kek.foundation.terrorhistory.data.region.Region
import kek.foundation.terrorhistory.data.targettypes.TargetType
import kotlinx.android.synthetic.main.sector_item.view.*
import java.lang.IllegalArgumentException

class SectorItemViewHolder<T>(
    parent: ViewGroup,
    private val onItemClickListener: (T) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.sector_item, parent, false)
) {


    fun bind(item: T, selected: Boolean = false) {
        applySelectedState(selected)

        with(itemView) {
            contentText.text = getText(item)

            setOnClickListener { onItemClickListener(item) }
        }
    }

    private fun applySelectedState(selected: Boolean) {
        if(selected) {
            itemView.contentText.setSelectedState()
        } else {
            itemView.contentText.setUnselectedState()
        }
    }

    private fun TextView.setSelectedState() {
        setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
        setTextColor(ContextCompat.getColor(context, R.color.colorAccent))
    }

    private fun TextView.setUnselectedState() {
        setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
        setTextColor(ContextCompat.getColor(context, R.color.colorPrimary))
    }

    private fun getText(item: T): String =
        when (item) {
            is Country -> item.name
            is AttackType -> item.name
            is Group -> item.name
            is Region -> item.name
            is TargetType -> item.name
            else -> throw IllegalArgumentException("No filter parameter exists $item")
        }
}