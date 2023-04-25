package com.communeo.common.data.models.event

import com.communeo.common.data.models.user.AuthenticatedUser

data class EventSearch(
    val searchingUser: AuthenticatedUser,
    val searchQuery: String? = null,
    val filters: EventFilter? = null,
)
