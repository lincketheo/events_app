package com.communeo.common.data.repository.queries

import com.communeo.common.data.models.common.DateRange
import com.communeo.common.data.models.event.Event
import com.communeo.common.data.models.user.PublicUser

data class EventsFilter(
    val dateRange: DateRange? = null,
    val filterOwners: HashSet<PublicUser>? = null,
) {
    fun matches(event: Event): Boolean {
        val inDateRange = dateRange?.let { (fromDate, toDate) ->
            toDate < event.dateOccurring && event.dateOccurring < fromDate
        } ?: true
        val inOwners = filterOwners?.contains(event.organizer) ?: true
        return inDateRange && inOwners
    }
}
