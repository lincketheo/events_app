package com.communeo.mobile.android.core.models.events.data.source.network.api

import com.communeo.common.data.repository.queries.EventsQuery
import com.communeo.mobile.android.core.models.events.data.source.network.models.EventResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitEventAPI {
    @GET("/events/{eventId}")
    suspend fun getEvent(
        @Header("Authorization") authorization: String,
        @Path("eventId") eventId: String,
    ): EventResponse

    @GET("/events/feed")
    suspend fun getEventFeed(
        @Header("Authorization") authorization: String,
    ): List<EventResponse>

    @POST("/events/search")
    suspend fun constructEventSearch(
        @Header("Authorization") authorization: String,
        @Body query: EventsQuery,
    ): List<EventResponse>
}
