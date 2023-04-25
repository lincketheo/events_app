package com.communeo.common.data.repository

import com.communeo.common.data.models.event.Event
import com.communeo.common.data.repository.queries.EventsQuery
import kotlinx.coroutines.flow.Flow

interface EventRepository {
    /**
     * Returns a single event
     */
    suspend fun getEvent(eventId: String)

    /**
     * Represents a stream of events to use
     * in the feed. When the consumer needs
     * more events, it should call [needMoreEventsForFeed]
     */
    val eventFeed: Flow<Event>
    suspend fun needMoreEventsForFeed(): Boolean

    /**
     * Represents a stream of events to
     */
    fun eventSearch(query: EventsQuery): Flow<Event>
    suspend fun needMoreEventsForSearch(query: EventsQuery)
}
