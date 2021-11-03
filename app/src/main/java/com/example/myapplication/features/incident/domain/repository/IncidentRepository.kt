package com.example.myapplication.features.incident.domain.repository

import com.example.myapplication.features.incident.data.network.IncidentApiInterface
import com.example.myapplication.features.incident.data.network.mapper.ApiIncidentMapper
import com.example.myapplication.features.incident.domain.model.Incident
import com.example.myapplication.commen.network.Result
import javax.inject.Inject

class IncidentRepository @Inject constructor(
    private val remote: IncidentApiInterface,
    private val apiIncidentMapper: ApiIncidentMapper
) : IncidentRepositoryInterface {
    override suspend fun getIncident(): Result<List<Incident>> =
        when (val result = remote.getIncidentList()) {
            is Result.Success -> Result.Success(result.value.incidents.orEmpty().map { apiIncidentMapper.mapTo(it) })
            is Result.Failure -> Result.Failure(result.errorHolder)
        }
}