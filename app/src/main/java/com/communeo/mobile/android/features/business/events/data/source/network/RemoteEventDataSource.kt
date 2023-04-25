package com.communeo.mobile.android.features.business.events.data.source.network

import com.communeo.mobile.android.features.business.events.data.models.EventSearch
import com.communeo.mobile.android.features.business.events.data.source.network.models.EventResponse

interface RemoteEventDataSource {
    suspend fun getEvent(
        eventId: String,
    ): EventResponse

    suspend fun getEventFeed(
        page: UInt,
        pageSize: UInt,
    ): List<EventResponse>

    suspend fun getEventsFromSearch(
        page: Int,
        pageSize: Int,
        search: EventSearch,
    ): List<EventResponse>
}
