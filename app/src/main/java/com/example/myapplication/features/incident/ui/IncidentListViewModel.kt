package com.example.myapplication.features.incident.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.commen.ViewState
import com.example.myapplication.commen.network.Result
import com.example.myapplication.features.incident.domain.repository.IncidentRepositoryInterface
import com.example.myapplication.features.incident.ui.data.mapper.UiIncidentMapper
import com.example.myapplication.features.incident.ui.data.model.UiIncident
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IncidentListViewModel @Inject constructor(
    private val incidentRepository: IncidentRepositoryInterface,
    private val uiIncidentMapper: UiIncidentMapper,
) : ViewModel() {

    private val _incidents: MutableStateFlow<ViewState<List<UiIncident>>> = MutableStateFlow(ViewState.Loading())
    val incidents: StateFlow<ViewState<List<UiIncident>>> = _incidents
    fun loadIncident() {
        viewModelScope.launch(Dispatchers.IO) {
            _incidents.emit(ViewState.Loading())
            val viewState = when(val result = incidentRepository.getIncident()) {
                is Result.Success -> ViewState.Succes(result.value.map { uiIncidentMapper.mapTo(it) })
                is Result.Failure -> ViewState.Error(result.errorHolder.message)
            }
            _incidents.emit(viewState)
        }
    }
}