package com.example.myapplication.features.incident.data.network.model


import com.google.gson.annotations.SerializedName

class ApiIncidentTypesResponse : ArrayList<ApiIncidentTypesItem>()

data class ApiIncidentTypesItem(
    @SerializedName("arabicName")
    val arabicName: String?,
    @SerializedName("englishName")
    val englishName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("subTypes")
    val subTypes: List<ApiSubTypeItem>?
)

data class ApiSubTypeItem(
    @SerializedName("arabicName")
    val arabicName: String?,
    @SerializedName("categoryId")
    val categoryId: Int?,
    @SerializedName("englishName")
    val englishName: String?,
    @SerializedName("id")
    val id: Int?
)