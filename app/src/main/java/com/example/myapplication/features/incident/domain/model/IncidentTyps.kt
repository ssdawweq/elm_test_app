package com.example.myapplication.features.incident.domain.model

data class IncidentType(
    val arabicName: String,
    val englishName: String,
    val id: Int,
    val subTypes: List<SubType>
)

data class SubType(
    val arabicName: String,
    val categoryId: Int,
    val englishName: String,
    val id: Int
)