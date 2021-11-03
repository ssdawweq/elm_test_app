package com.example.myapplication.injection

import com.example.myapplication.features.incident.data.network.IncidentApiIntreface
import com.example.myapplication.features.incident.data.network.IncidentRetrofitClient
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class NetworkModule {

    @Binds
    abstract fun getIncidentRemote(incidentRetrofitClient: IncidentRetrofitClient): IncidentApiIntreface
}