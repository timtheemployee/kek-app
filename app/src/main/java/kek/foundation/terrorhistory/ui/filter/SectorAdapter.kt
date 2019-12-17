package kek.foundation.terrorhistory.ui.filter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SectorAdapter<T>(
    private val items: List<T>,
    private val selectedItems: MutableSet<T>,
    private val onItemClickListener: (T) -> Unit
) : RecyclerView.Adapter<SectorItemViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectorItemViewHolder<T> =
        SectorItemViewHolder(parent, onItemClickListener)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SectorItemViewHolder<T>, position: Int) {
        val bindedItem = items[position]
        holder.bind(item = bindedItem, selected = selectedItems.contains(bindedItem))
    }
}