package com.communeo.mobile.android.features.feed.domain

import com.communeo.mobile.android.features.business.events.data.models.Event
import com.communeo.mobile.android.features.business.events.data.repository.EventRepository
import javax.inject.Inject

class GetEventFeedUseCase @Inject constructor(
    private val eventRepository: EventRepository,
) {
    suspend operator fun invoke(page: UInt, pageSize: UInt): List<Event> {
        return eventRepository
            .getEventFeed(
                page = page,
                pageSize = pageSize,
            )
    }
}
