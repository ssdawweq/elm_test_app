package com.example.myapplication.features.incident.data.network

import com.example.myapplication.commen.network.Result
import com.example.myapplication.features.incident.data.network.model.ApiIncidentResponse

interface IncidentApiInterface {
    suspend fun getIncidentList(): Result<ApiIncidentResponse>
}