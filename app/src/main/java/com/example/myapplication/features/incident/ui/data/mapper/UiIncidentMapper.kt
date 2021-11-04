package com.example.myapplication.features.incident.ui.data.mapper

import com.example.myapplication.commen.Mapper
import com.example.myapplication.features.incident.domain.model.Incident
import com.example.myapplication.features.incident.domain.model.IncidentType
import com.example.myapplication.features.incident.ui.data.model.UiIncident
import java.util.*
import javax.inject.Inject

class UiIncidentMapper @Inject constructor(
    private val locale: Locale
) : Mapper<Pair<Incident, List<IncidentType>>, UiIncident> {
    override fun mapTo(pair: Pair<Incident, List<IncidentType>>): UiIncident = with(pair.first) { UiIncident(
        id = id,
        description = description,
        incidentType = when (locale.language) {
            "ar" -> pair.second.firstOrNull { typeId == it.id }?.arabicName.orEmpty()
            else -> pair.second.firstOrNull { typeId == it.id }?.englishName.orEmpty()
        }
    ) }
}