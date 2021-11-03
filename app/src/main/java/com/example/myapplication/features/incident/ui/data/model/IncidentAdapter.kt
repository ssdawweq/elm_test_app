package com.example.myapplication.features.incident.ui.data.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.IncidentItemListBinding

class IncidentAdapter: ListAdapter<UiIncident, IncidentAdapter.IncidentViewHolder>(ITEM_COMPARATOR) {

    class IncidentViewHolder(val binding: IncidentItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binding(uiIncident: UiIncident) = with(binding){
            tvDateOfCreation.text = uiIncident.creationDate
            tvIncidentDescription.text = uiIncident.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidentViewHolder {
        val binding = IncidentItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return IncidentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IncidentViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding(item)
    }
}

private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<UiIncident>() {
    override fun areItemsTheSame(oldItem: UiIncident, newItem: UiIncident): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: UiIncident, newItem: UiIncident): Boolean = oldItem == newItem
}