package com.gabriel.desafioshopper.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gabriel.desafioshopper.R
import com.gabriel.desafioshopper.data.model.EstimateRequest
import com.gabriel.desafioshopper.databinding.FragmentHomeBinding
import com.gabriel.desafioshopper.domain.model.RideEstimate
import com.gabriel.desafioshopper.util.StateView
import com.gabriel.desafioshopper.util.showButtonSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initObservers()
    }

    private fun initListeners() {
        binding.btnRequest.setOnClickListener { validateData() }
    }

    private fun validateData() {
        val customerId = binding.editCustomerId.text.toString()
        val origin = binding.editOrigin.text.toString()
        val destination = binding.destination.text.toString()

        if (customerId.isNotEmpty()) {
            if (origin.isNotEmpty()) {
                if (destination.isNotEmpty()) {
                    val request = EstimateRequest(
                        customerId = customerId,
                        origin = origin,
                        destination = destination
                    )
                    viewModel.getRideEstimate(request)
                } else {
                    showButtonSheet(message = getString(R.string.text_destination_empty_home_fragment))
                }
            } else {
                showButtonSheet(message = getString(R.string.text_origin_empty_home_fragment))
            }
        } else {
            showButtonSheet(message = getString(R.string.text_id_empty_home_fragment))
        }
    }

    private fun initObservers() {
        viewModel.rideEstimateState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is StateView.Loading -> {
                    binding.progressLoading.isVisible = true
                }

                is StateView.Success -> {
                    state.data?.let { navigateToRideOptions(it) }
                    binding.progressLoading.isVisible = false
                    Toast.makeText(requireContext(), "Sucesso", Toast.LENGTH_LONG).show()
                }

                is StateView.Error -> {
                    binding.progressLoading.isVisible = false
                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun navigateToRideOptions(rideEstimate: RideEstimate) {
        binding.progressLoading.isVisible = false
        val action = HomeFragmentDirections.actionHomeFragmentToRideConfirmFragment(rideEstimate)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}