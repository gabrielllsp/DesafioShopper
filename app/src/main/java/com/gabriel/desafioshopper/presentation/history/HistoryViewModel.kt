package com.gabriel.desafioshopper.presentation.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabriel.desafioshopper.data.model.TripHistoryResponse
import com.gabriel.desafioshopper.domain.usecase.GetTripHistoryUseCase
import com.gabriel.desafioshopper.util.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getTripHistoryUseCase: GetTripHistoryUseCase
) : ViewModel() {
    private val _tripHistoryState = MutableLiveData<StateView<TripHistoryResponse>>()
    val tripHistoryState: MutableLiveData<StateView<TripHistoryResponse>> = _tripHistoryState

    fun getTripHistory(customerId: String, driverId: Int? = null) {
        viewModelScope.launch {
            _tripHistoryState.postValue(StateView.Loading())
            try {
                val trips = getTripHistoryUseCase(customerId, driverId)
                _tripHistoryState.postValue(StateView.Success(trips))
            } catch (e: Exception) {
                _tripHistoryState.postValue(StateView.Error("Erro ao carregar histórico: ${e.message}"))
            }
        }
    }
}