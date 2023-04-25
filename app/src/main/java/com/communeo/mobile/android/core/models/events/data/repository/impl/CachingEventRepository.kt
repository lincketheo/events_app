package com.communeo.mobile.android.core.models.events.data.repository.impl

import com.communeo.common.data.models.event.Event
import com.communeo.common.data.repository.EventRepository
import com.communeo.common.data.repository.queries.EventsQuery

class CachingEventRepository : EventRepository {
    override suspend fun getEventsWithQuery(query: EventsQuery): List<Event> {
        TODO()
    }
}
