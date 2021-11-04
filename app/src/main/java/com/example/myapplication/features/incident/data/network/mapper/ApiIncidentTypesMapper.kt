package com.example.myapplication.features.incident.data.network.mapper

import com.example.myapplication.commen.Mapper
import com.example.myapplication.features.incident.data.network.model.ApiIncidentTypesItem
import com.example.myapplication.features.incident.data.network.model.ApiSubTypeItem
import com.example.myapplication.features.incident.domain.model.IncidentType
import com.example.myapplication.features.incident.domain.model.SubType
import java.lang.Exception
import javax.inject.Inject

class ApiIncidentTypesMapper @Inject constructor(
    private val apiIncidentSubTypesMapper: ApiIncidentSubTypesMapper
) : Mapper<ApiIncidentTypesItem, IncidentType> {
    override fun mapTo(api: ApiIncidentTypesItem): IncidentType = with(api) { IncidentType(
        arabicName = arabicName.orEmpty(),
        englishName = englishName.orEmpty(),
        id = id ?: throw Exception("id of incident type can't be null"),
        subTypes = subTypes.orEmpty().map { apiIncidentSubTypesMapper.mapTo(it) }
    ) }
}

class ApiIncidentSubTypesMapper @Inject constructor(
) : Mapper<ApiSubTypeItem, SubType> {
    override fun mapTo(api: ApiSubTypeItem): SubType = with(api) { SubType(
        arabicName = arabicName.orEmpty(),
        englishName = englishName.orEmpty(),
        id = id ?: throw Exception("id of subtype can't be null"),
        categoryId = categoryId ?: throw Exception("categoryId of subtype can't be null"),
    ) }
}