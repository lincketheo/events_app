package com.communeo.common.data.repository.queries

import com.communeo.common.data.models.user.PublicUser
import com.communeo.common.data.repository.queries.EventsFilter

data class EventsQuery(
    val user: PublicUser,
    val searchQuery: String? = null,
    val filters: EventsFilter? = null,
    val page: Int,
    val pageSize: Int,
)
