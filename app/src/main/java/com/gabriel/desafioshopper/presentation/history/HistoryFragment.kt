package com.gabriel.desafioshopper.presentation.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabriel.desafioshopper.databinding.FragmentHistoryBinding
import com.gabriel.desafioshopper.presentation.history.adapter.TripAdapter
import com.gabriel.desafioshopper.util.StateView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HistoryViewModel by viewModels()
    private lateinit var adapter: TripAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
        viewModel.getTripHistory(customerId = "123", driverId = null)
    }

    private fun setupRecyclerView() {
        adapter = TripAdapter(
            item = listOf()
        )
        binding.rvHistory.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter
        }
    }

    private fun observeViewModel() {
        viewModel.tripHistoryState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is StateView.Loading -> binding.progressLoading.isVisible = true
                is StateView.Success -> {
                    val data = state.data
                    binding.progressLoading.isVisible = false
                }

                is StateView.Error -> {
                    binding.progressLoading.isVisible = false
                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}