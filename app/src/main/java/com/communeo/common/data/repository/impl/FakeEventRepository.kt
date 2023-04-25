package com.communeo.common.data.repository.impl

import com.communeo.common.data.models.event.Event
import com.communeo.common.data.repository.EventRepository
import com.communeo.common.data.repository.queries.EventsQuery
import kotlinx.coroutines.delay
import kotlin.math.min

class FakeEventRepository : EventRepository {

    companion object {
        val events = (0..30).map {
            Event.random(
                organizer = FakeUserRepository.randomUser()
            )
        }
    }

    override suspend fun getEventsWithQuery(query: EventsQuery): List<Event> {
        delay(2000L)

        with(query) {
            val filteredEvents = filters?.let { filter ->
                events.filter(filter::matches)
            } ?: events

            val startingIndex = page * pageSize
            return if (startingIndex < filteredEvents.size) {
                filteredEvents.slice(
                    startingIndex until min(
                        startingIndex + pageSize,
                        filteredEvents.size
                    )
                )
            } else emptyList()
        }
    }
}
