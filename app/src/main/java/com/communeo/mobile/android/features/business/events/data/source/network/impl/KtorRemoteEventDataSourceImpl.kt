package com.communeo.mobile.android.features.business.events.data.source.network.impl

import com.communeo.mobile.android.core.network.CommonKtorDataSource
import com.communeo.mobile.android.core.util.toQueryString
import com.communeo.mobile.android.features.business.events.data.models.Event
import com.communeo.mobile.android.features.business.events.data.models.EventSearch
import com.communeo.mobile.android.features.business.events.data.source.network.RemoteEventDataSource
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class KtorRemoteEventDataSourceImpl @Inject constructor() : RemoteEventDataSource,
    CommonKtorDataSource() {
    override suspend fun getEvent(eventId: String): Event {
        val url = "$baseUrl/events/$eventId"
        return client.get(url).body()
    }

    override suspend fun getEventFeed(page: UInt, pageSize: UInt): List<Event> {
        val queryParams = mapOf(
            "page" to page.toString(),
            "pageSize" to pageSize.toString()
        )

        val url = "$baseUrl/events?${queryParams.toQueryString()}"
        return client.post(url).body()
    }

    override suspend fun getEventsFromSearch(
        page: Int,
        pageSize: Int,
        search: EventSearch
    ): List<Event> {
        val queryParams = mapOf(
            "page" to page.toString(),
            "pageSize" to pageSize.toString()
        )

        val url = "$baseUrl/events?${queryParams.toQueryString()}"
        return client.post(url) {
            setBody(search)
        }.body()
    }
}
