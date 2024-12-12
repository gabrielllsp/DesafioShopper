package com.gabriel.desafioshopper.presentation.ride_options

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabriel.desafioshopper.data.model.ConfirmRideRequest
import com.gabriel.desafioshopper.domain.model.Confirm
import com.gabriel.desafioshopper.domain.usecase.GetConfirmRideUseCase
import com.gabriel.desafioshopper.util.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfirmRideViewModel @Inject constructor(
    private val confirmRideUseCase: GetConfirmRideUseCase
) : ViewModel() {
    private val _confirmationState = MutableLiveData<StateView<Confirm>>()
    val confirmationState: LiveData<StateView<Confirm>> = _confirmationState

    fun confirmRide(request: ConfirmRideRequest) {
        viewModelScope.launch {
            _confirmationState.postValue(StateView.Loading())
            try {
                val success = confirmRideUseCase(request)
                _confirmationState.postValue(StateView.Success(success))
            } catch (e: Exception) {
                _confirmationState.postValue(StateView.Error("Erro ao confirmar a viagem: ${e.message}"))
            }
        }
    }
}