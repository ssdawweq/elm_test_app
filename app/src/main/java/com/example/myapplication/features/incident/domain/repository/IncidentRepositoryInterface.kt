package com.example.myapplication.features.incident.domain.repository

import com.example.myapplication.commen.network.Result
import com.example.myapplication.features.incident.domain.model.Incident

interface IncidentRepositoryInterface {
    suspend fun getIncident(): Result<List<Incident>>
}