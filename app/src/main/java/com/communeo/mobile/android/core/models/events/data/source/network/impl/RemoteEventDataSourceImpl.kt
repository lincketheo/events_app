package com.communeo.mobile.android.core.models.events.data.source.network.impl

import com.communeo.common.data.repository.queries.EventsQuery
import com.communeo.mobile.android.core.coroutines.di.IoDispatcher
import com.communeo.mobile.android.core.models.events.data.source.network.RemoteEventDataSource
import com.communeo.mobile.android.core.models.events.data.source.network.api.RetrofitEventAPI
import com.communeo.mobile.android.core.models.events.data.source.network.models.EventResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteEventDataSourceImpl @Inject constructor(
    private val retrofitEventAPI: RetrofitEventAPI,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : RemoteEventDataSource {
    override suspend fun getEvent(eventId: String): EventResponse {
        return withContext(ioDispatcher) {
            retrofitEventAPI.getEvent(
                authorization = "TODO",
                eventId = eventId,
            )
        }
    }

    override suspend fun getEventFeed(): List<EventResponse> {
        return withContext(ioDispatcher) {
            retrofitEventAPI.getEventFeed(
                authorization = "TODO",
            )
        }
    }

    override suspend fun getEventsFromSearch(query: EventsQuery): List<EventResponse> {
        return withContext(ioDispatcher) {
            retrofitEventAPI.constructEventSearch(
                authorization = "TODO",
                query = query,
            )
        }
    }
}
