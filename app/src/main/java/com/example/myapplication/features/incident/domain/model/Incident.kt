package com.example.myapplication.features.incident.domain.model

import com.example.myapplication.features.incident.data.network.model.ApiMediaItem
import com.google.gson.annotations.SerializedName

data class Incident(
    val assigneeId: Long,
    val createdAt: String,
    val description: String,
    val id: String,
    val issuerId: String,
    val latitude: Double,
    val longitude: Double,
    val medias: List<MediaItem>,
    val priority: Int,
    val status: Int,
    val typeId: Int,
    val updatedAt: String
)

data class MediaItem(
    val id: String,
    val incidentId: String,
    val mimeType: String,
    val type: Int,
    val url: String
)