package ru.clonsaldafon.practise09_11_2024.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.clonsaldafon.practise09_11_2024.R
import ru.clonsaldafon.practise09_11_2024.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()

    private val viewModel: MainViewModel by viewModels()

    private val adapter = IntercomsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding.intercomsRecycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@MainFragment.adapter
        }

        adapter.submitList(
            listOf(
                Intercom(1, "Beward"),
                Intercom(2, "Sokol")
            )
        )

        super.onViewCreated(view, savedInstanceState)
    }

}