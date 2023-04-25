package com.communeo.mobile.android.features.business.events.data.repository

import com.communeo.mobile.android.features.business.events.data.models.Event
import com.communeo.mobile.android.features.business.events.data.models.EventSearch

interface EventRepository {
    suspend fun getEvent(eventId: ULong): Event

    suspend fun getEventFeed(
        page: UInt,
        pageSize: UInt,
    ): List<Event>

    suspend fun getEventsFromSearch(
        page: Int,
        pageSize: Int,
        search: EventSearch,
    ): List<Event>
}
