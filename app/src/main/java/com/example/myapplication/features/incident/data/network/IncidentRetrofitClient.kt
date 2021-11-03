package com.example.myapplication.features.incident.data.network

import com.example.myapplication.commen.network.ErrorHolder
import com.example.myapplication.commen.network.RetrofitClient
import com.example.myapplication.commen.network.Result
import com.example.myapplication.features.incident.data.network.model.ApiIncidentResponse
import javax.inject.Inject

class IncidentRetrofitClient @Inject constructor(
    retrofitClient: RetrofitClient
) : IncidentApiInterface {
    private val remote = retrofitClient.getService(IncidentApi::class.java)
    override suspend fun getIncidentList(): Result<ApiIncidentResponse> =
        try {
            Result.Success(remote.getIncidentList())
        } catch (e: Exception) {
            Result.Failure(ErrorHolder.BadRequest(e.message.orEmpty()))
        }
}