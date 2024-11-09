package ru.clonsaldafon.practise09_11_2024.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import ru.clonsaldafon.practise09_11_2024.data.model.Intercom
import ru.clonsaldafon.practise09_11_2024.data.model.IntercomType
import ru.clonsaldafon.practise09_11_2024.databinding.IntercomViewholderBinding

class IntercomsAdapter(
    private val onOpenClick: (Intercom) -> Unit,
    private val onCallClick: (Intercom) -> Unit
) : ListAdapter<Intercom, IntercomsAdapter.IntercomViewHolder>(IntercomDiffUtil()) {

    class IntercomViewHolder(
        private val onOpenClick: (Intercom) -> Unit,
        private val onCallClick: (Intercom) -> Unit,
        private val binding: IntercomViewholderBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(intercom: Intercom) = with(binding) {
            intercomName.text = intercom.name

            intercomOpen.setOnClickListener {
                onOpenClick(intercom)
            }
            intercomCall.setOnClickListener {
                onCallClick(intercom)
            }
            intercomSnapshot.load(intercom.snapshotUrl) {
                httpHeaders(
                    NetworkHeaders.Builder()
                        .let {
                            when(intercom.type) {
                                IntercomType.SOKOL -> it.set("Authorization", "Basic cm9vdDoxMjM0NTY=")
                                IntercomType.BEWARD -> it.set("Authorization", "Basic YWRtaW46YWRtaW4=")
                            }
                        }
                        .build()
                )
            }

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
        return IntercomViewHolder(onOpenClick, onCallClick, binding)
    }

    override fun onBindViewHolder(holder: IntercomViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

}