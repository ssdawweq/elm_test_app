package com.example.myapplication.features.incident.domain.repository

import com.example.myapplication.features.incident.data.network.IncidentApiInterface
import com.example.myapplication.features.incident.data.network.mapper.ApiIncidentMapper
import com.example.myapplication.features.incident.domain.model.Incident
import com.example.myapplication.commen.network.Result
import com.example.myapplication.features.incident.data.network.mapper.ApiIncidentTypesMapper
import com.example.myapplication.features.incident.domain.model.IncidentType
import javax.inject.Inject

class IncidentRepository @Inject constructor(
    private val remote: IncidentApiInterface,
    private val apiIncidentMapper: ApiIncidentMapper,
    private val apiIncidentTypesMapper: ApiIncidentTypesMapper
) : IncidentRepositoryInterface {
    override suspend fun getIncident(): Result<List<Incident>> =
        when (val result = remote.getIncidentList()) {
            is Result.Success -> Result.Success(result.value.incidents.orEmpty().map { apiIncidentMapper.mapTo(it) })
            is Result.Failure -> Result.Failure(result.errorHolder)
        }

    override suspend fun getIncidentTypes(): Result<List<IncidentType>> =
        when (val result = remote.getIncidentTypes()) {
            is Result.Success -> Result.Success(result.value.map { apiIncidentTypesMapper.mapTo(it) })
            is Result.Failure -> Result.Failure(result.errorHolder)
        }
}
