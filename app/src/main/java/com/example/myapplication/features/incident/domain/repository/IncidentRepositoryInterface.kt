package com.example.myapplication.features.incident.domain.repository

import com.example.myapplication.commen.network.Result
import com.example.myapplication.features.incident.domain.model.Incident
import com.example.myapplication.features.incident.domain.model.IncidentType

interface IncidentRepositoryInterface {
    suspend fun getIncident(): Result<List<Incident>>
    suspend fun getIncidentTypes(): Result<List<IncidentType>>
}