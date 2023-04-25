package com.communeo.mobile.android.core.models.events.data.source.network

import com.communeo.common.data.repository.queries.EventsQuery
import com.communeo.mobile.android.core.models.events.data.source.network.models.EventResponse

interface RemoteEventDataSource {
    suspend fun getEvent(eventId: String): EventResponse
    suspend fun getEventFeed(): List<EventResponse>
    suspend fun getEventsFromSearch(query: EventsQuery): List<EventResponse>
}
