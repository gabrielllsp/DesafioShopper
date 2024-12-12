package com.gabriel.desafioshopper.presentation.ride_options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.gabriel.desafioshopper.R
import com.gabriel.desafioshopper.data.model.ConfirmRideRequest
import com.gabriel.desafioshopper.databinding.FragmentConfirmRideBinding
import com.gabriel.desafioshopper.domain.model.Driver
import com.gabriel.desafioshopper.domain.model.RideEstimate
import com.gabriel.desafioshopper.domain.model.RideOption
import com.gabriel.desafioshopper.presentation.ride_options.adapter.DriverOptionsAdapter
import com.gabriel.desafioshopper.util.StateView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfirmRideFragment : Fragment() {

    private var _binding: FragmentConfirmRideBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ConfirmRideViewModel by viewModels()
    private lateinit var adapter: DriverOptionsAdapter
    private val args: ConfirmRideFragmentArgs by navArgs()
    private lateinit var rideEstimate: RideEstimate

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfirmRideBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rideEstimate = ConfirmRideFragmentArgs.fromBundle(requireArguments()).rideEstimate

        setupRecyclerView()
        displayMap(rideEstimate)
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = DriverOptionsAdapter(
            rideEstimate.options
        ) { selectedDriver ->
            handleDriverSelection(selectedDriver)
        }

        binding.rvDrivers.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter
        }
    }

    private fun handleDriverSelection(driver: RideOption) {
        val request = ConfirmRideRequest(
            customerId = "123",
            origin = "${rideEstimate.origin.latitude},${rideEstimate.origin.longitude}",
            destination = "${rideEstimate.destination.latitude},${rideEstimate.destination.longitude}",
            distance = rideEstimate.distance,
            duration = rideEstimate.duration,
            driver = Driver(driver.id, driver.name),
            value = driver.value
        )
        viewModel.confirmRide(request)
    }

    private fun displayMap(rideEstimate: RideEstimate) {
        val mapUrl = "https://maps.googleapis.com/maps/api/staticmap?" +
                "size=600x300&" +
                "markers=color:blue|label:A|${rideEstimate.origin.latitude},${rideEstimate.origin.longitude}" +
                "&markers=color:red|label:B|${rideEstimate.destination.latitude},${rideEstimate.destination.longitude}" +
                "&path=color:blue|weight:5|${rideEstimate.origin.latitude},${rideEstimate.origin.longitude}|${rideEstimate.destination.latitude},${rideEstimate.destination.longitude}" +
                "&key= **************"

        Glide.with(requireContext())
            .load(mapUrl)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_map)
            .into(binding.imgMap)
    }

    private fun observeViewModel() {
        viewModel.confirmationState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is StateView.Loading -> binding.progressLoading.isVisible = true
                is StateView.Success -> {
                    binding.progressLoading.isVisible = false
                    Toast.makeText(requireContext(), "Viagem Confirmada!", Toast.LENGTH_SHORT)
                        .show()
                }

                is StateView.Error -> {
                    binding.progressLoading.isVisible = false
                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}