package com.communeo.mobile.android.features.business.events.data.models

import com.communeo.mobile.android.features.business.users.data.models.PublicUser
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class EventFilter(
    val fromDate: Instant?,
    val toDate: Instant?,
    val owners: Set<PublicUser>?,
) {
    fun matches(event: Event): Boolean {
        return (fromDate?.let { event.dateOccurring >= it } ?: true) &&
            (toDate?.let { event.dateOccurring <= it } ?: true) &&
            (owners?.let { event.organizer in it } ?: true)
    }
}
