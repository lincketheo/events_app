package com.communeo.mobile.android.features.business.events.data.repository.impl

import com.communeo.mobile.android.features.business.events.data.models.Event
import com.communeo.mobile.android.features.business.events.data.models.EventSearch
import com.communeo.mobile.android.features.business.events.data.repository.EventRepository
import com.communeo.mobile.android.features.business.events.data.source.network.RemoteEventDataSource
import com.communeo.mobile.android.features.business.events.data.source.network.models.toEvent
import javax.inject.Inject

class OnlyNetworkEventRepositoryImpl @Inject constructor(
    private val remoteEventDataSource: RemoteEventDataSource,
) : EventRepository {
    override suspend fun getEvent(eventId: ULong): Event {
        return remoteEventDataSource
            .getEvent(eventId.toString())
            .toEvent()
    }

    override suspend fun getEventFeed(
        page: UInt,
        pageSize: UInt,
    ): List<Event> {
        return remoteEventDataSource
            .getEventFeed(
                page = page,
                pageSize = pageSize,
            )
            .map { it.toEvent() }
    }

    override suspend fun getEventsFromSearch(
        page: Int,
        pageSize: Int,
        search: EventSearch
    ): List<Event> {
        return remoteEventDataSource
            .getEventsFromSearch(
                page = page,
                pageSize = pageSize,
                search = search,
            )
            .map { it.toEvent() }
    }
}
