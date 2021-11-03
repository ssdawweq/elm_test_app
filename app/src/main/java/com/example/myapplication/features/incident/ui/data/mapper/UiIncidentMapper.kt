package com.example.myapplication.features.incident.ui.data.mapper

import com.example.myapplication.commen.Mapper
import com.example.myapplication.features.incident.domain.model.Incident
import com.example.myapplication.features.incident.ui.data.model.UiIncident
import javax.inject.Inject

class UiIncidentMapper @Inject constructor(

) : Mapper<Incident, UiIncident> {
    override fun mapTo(domain: Incident): UiIncident = with(domain) { UiIncident(
        id = id,
        description = description,
        creationDate = createdAt
    )
    }
}