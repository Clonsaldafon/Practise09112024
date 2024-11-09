package ru.clonsaldafon.practise09_11_2024.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.clonsaldafon.practise09_11_2024.R
import ru.clonsaldafon.practise09_11_2024.databinding.FragmentMainBinding
import ru.clonsaldafon.practise09_11_2024.di.ViewModelFactory
import ru.clonsaldafon.practise09_11_2024.di.appComponent
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {

    @Inject
    lateinit var factory: ViewModelFactory

    private val binding: FragmentMainBinding by viewBinding()

    private val viewModel: MainViewModel by viewModels { factory }

    private val adapter = IntercomsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding.intercomsRecycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@MainFragment.adapter
        }

        viewModel.intercoms.observe(viewLifecycleOwner) { intercoms ->
            adapter.submitList(intercoms)
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

}