package com.example.myapplication.features.incident.data.network

import com.example.myapplication.features.incident.data.network.model.ApiIncidentResponse
import retrofit2.Response
import retrofit2.http.GET


interface IncidentApi {

    @GET("incident")
    suspend fun getIncidentList(): ApiIncidentResponse
}