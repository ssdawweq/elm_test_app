package com.example.myapplication.features.incident.data.network.model


import com.google.gson.annotations.SerializedName

data class ApiIncidentResponse(
    @SerializedName("baseURL")
    val baseURL: String?,
    @SerializedName("incidents")
    val incidents: List<ApiIncidentItem>?
)