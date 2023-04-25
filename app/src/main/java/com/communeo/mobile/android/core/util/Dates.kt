package com.communeo.mobile.android.core.util

import kotlinx.datetime.*

fun generateRandomDate(): LocalDateTime {
    val currentMoment = Clock.System.now()
    return currentMoment.toLocalDateTime(TimeZone.currentSystemDefault())
}

fun generateRandomInstant(): Instant {
    return Clock.System.now()
}
