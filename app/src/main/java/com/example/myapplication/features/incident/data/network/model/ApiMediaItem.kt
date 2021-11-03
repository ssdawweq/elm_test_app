package com.example.myapplication.features.incident.data.network.model


import com.google.gson.annotations.SerializedName

data class ApiMediaItem(
    @SerializedName("id")
    val id: String?,
    @SerializedName("incidentId")
    val incidentId: String?,
    @SerializedName("mimeType")
    val mimeType: String?,
    @SerializedName("type")
    val type: Int?,
    @SerializedName("url")
    val url: String?
)