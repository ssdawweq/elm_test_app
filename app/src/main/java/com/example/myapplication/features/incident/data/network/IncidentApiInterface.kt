package com.example.myapplication.features.incident.data.network

import com.example.myapplication.commen.network.Result
import com.example.myapplication.features.incident.data.network.model.ApiIncidentResponse
import com.example.myapplication.features.incident.data.network.model.ApiIncidentTypesResponse

interface IncidentApiInterface {
    suspend fun getIncidentList(): Result<ApiIncidentResponse>
    suspend fun getIncidentTypes(): Result<ApiIncidentTypesResponse>
}