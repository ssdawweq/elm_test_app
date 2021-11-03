package com.example.myapplication.features.incident.data.network

import com.example.myapplication.commen.network.RetrofitClient
import com.example.myapplication.features.incident.data.network.model.ApiIncidentResponse
import javax.inject.Inject

class IncidentRetrofitClient @Inject constructor(
    private val retrofitClient: RetrofitClient
) : IncidentApiIntreface {
    private val remote = retrofitClient.getService(IncidentApi::class.java)
    override suspend fun getIncidentList(): Result<ApiIncidentResponse> =
        try {
            Result.success(remote.getIncidentList())
        } catch (e: Exception) {
            Result.failure(e)
        }
}