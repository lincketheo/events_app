package com.communeo.common.data.models.event

import com.communeo.common.data.models.user.PublicUser
import java.time.LocalDate

data class EventFilter(
    val fromDate: LocalDate?,
    val toDate: LocalDate?,
    val owners: Set<PublicUser>?,
) {
    fun matches(event: Event): Boolean {
        fromDate?.let { event.dateOccurring }
    }
}
