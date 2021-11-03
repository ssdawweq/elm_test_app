package com.example.myapplication.features.incident.data.network

import com.example.myapplication.features.incident.data.network.model.ApiIncidentResponse

interface IncidentApiIntreface {
    suspend fun getIncidentList(): Result<ApiIncidentResponse>
}