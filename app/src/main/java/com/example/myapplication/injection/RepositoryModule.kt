package com.example.myapplication.injection

import com.example.myapplication.features.incident.domain.repository.IncidentRepository
import com.example.myapplication.features.incident.domain.repository.IncidentRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun getIncidentRepository(incidentRepository: IncidentRepository) : IncidentRepositoryInterface
}