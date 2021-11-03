package com.example.myapplication.features.incident.data.network.model


import com.google.gson.annotations.SerializedName

data class ApiIncidentItem(
    @SerializedName("assigneeId")
    val assigneeId: Long?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("issuerId")
    val issuerId: String?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("medias")
    val medias: List<ApiMediaItem>?,
    @SerializedName("priority")
    val priority: Int?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("typeId")
    val typeId: Int?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)