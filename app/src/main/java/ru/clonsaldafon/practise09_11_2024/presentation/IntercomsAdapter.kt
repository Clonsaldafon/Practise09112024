package ru.clonsaldafon.practise09_11_2024.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.clonsaldafon.practise09_11_2024.databinding.IntercomViewholderBinding

class IntercomsAdapter : ListAdapter<Intercom, IntercomsAdapter.IntercomViewHolder>(IntercomDiffUtil()) {

    class IntercomViewHolder(
        private val binding: IntercomViewholderBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(intercom: Intercom) = with(binding) {
            intercomName.text = intercom.name
        }

    }

    class IntercomDiffUtil() : DiffUtil.ItemCallback<Intercom>() {

        override fun areItemsTheSame(oldItem: Intercom, newItem: Intercom): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Intercom, newItem: Intercom): Boolean =
            oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntercomViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = IntercomViewholderBinding.inflate(inflater, parent, false)
        return IntercomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntercomViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

}

data class Intercom(
    val id: Int,
    val name: String
)