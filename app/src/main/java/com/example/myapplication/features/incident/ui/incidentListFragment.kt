package com.example.myapplication.features.incident.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.commen.ViewState
import com.example.myapplication.databinding.FragmentIncidentListBinding
import com.example.myapplication.features.incident.ui.data.model.IncidentAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class IncidentListFragment: Fragment() {

    private var _binding: FragmentIncidentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<IncidentListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadIncident()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIncidentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUI()
    }

    private fun observeUI() = with(binding) {
        lifecycleScope.launchWhenStarted {
            viewModel.incidents.collect { state ->
                when(state) {
                    is ViewState.Loading -> {}
                    is ViewState.Error -> {}
                    is ViewState.Succes -> {
                        val adapter = IncidentAdapter()
                        rvIncidentList.adapter = adapter
                        adapter.submitList(state.item)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}