package com.example.myapplication.features.incident.data.network.mapper

import com.example.myapplication.commen.Mapper
import com.example.myapplication.features.incident.data.network.model.ApiIncidentItem
import com.example.myapplication.features.incident.data.network.model.ApiMediaItem
import com.example.myapplication.features.incident.domain.model.Incident
import com.example.myapplication.features.incident.domain.model.MediaItem
import javax.inject.Inject

class ApiIncidentMapper @Inject constructor(
    private val apiMediaItemMapper: ApiMediaItemMapper
): Mapper<ApiIncidentItem, Incident> {
    override fun mapTo(apiIncidentItem: ApiIncidentItem): Incident = with(apiIncidentItem) { Incident(
        assigneeId = assigneeId ?: -1,
        createdAt = createdAt.orEmpty(),
        description = description.orEmpty(),
        id = id ?: throw Exception("id of incident can't be null"),
        issuerId = issuerId.orEmpty(),
        latitude = latitude ?: 0.0,
        longitude = longitude ?: 0.0,
        medias = medias.orEmpty().map { apiMediaItemMapper.mapTo(it) },
        priority = priority ?: -1,
        status = status ?: -1,
        typeId = typeId ?: -1,
        updatedAt = updatedAt.orEmpty()
    ) }
}

class ApiMediaItemMapper @Inject constructor(
) : Mapper<ApiMediaItem, MediaItem> {
    override fun mapTo(apiMediaItem: ApiMediaItem): MediaItem = with(apiMediaItem) { MediaItem(
        id = id ?: throw Exception("id of MediaItem can't be null"),
        incidentId = incidentId ?: throw Exception(" incidentId of MediaItem can't be null"),
        mimeType = mimeType.orEmpty(),
        type = type ?: -1,
        url = url.orEmpty()
    ) }
}