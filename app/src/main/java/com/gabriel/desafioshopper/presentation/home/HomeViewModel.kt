package com.gabriel.desafioshopper.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabriel.desafioshopper.data.model.EstimateRequest
import com.gabriel.desafioshopper.domain.model.RideEstimate
import com.gabriel.desafioshopper.domain.usecase.GetRideEstimateUseCase
import com.gabriel.desafioshopper.util.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRideEstimateUseCase: GetRideEstimateUseCase
) : ViewModel() {

    private val _rideEstimateState = MutableLiveData<StateView<RideEstimate>>()
    val rideEstimateState: LiveData<StateView<RideEstimate>> = _rideEstimateState

    fun getRideEstimate(request: EstimateRequest) {
        viewModelScope.launch {
            _rideEstimateState.postValue(StateView.Loading())
            try {
                val result = getRideEstimateUseCase(request)
                _rideEstimateState.postValue(StateView.Success(result))
            } catch (e: Exception) {
                _rideEstimateState.postValue(StateView.Error("Erro: ${e.message}"))
            }
        }
    }
}