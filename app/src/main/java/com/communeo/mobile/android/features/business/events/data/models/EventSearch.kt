package com.communeo.mobile.android.features.business.events.data.models

import kotlinx.serialization.Serializable

@Serializable
data class EventSearch(
    val searchQuery: String? = null,
    val filters: EventFilter? = null,
)
