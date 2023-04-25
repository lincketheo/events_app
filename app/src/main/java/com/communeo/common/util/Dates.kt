package com.communeo.common.util

import java.util.Date
import kotlin.random.Random

fun generateRandomDate(): Date {
    val currentDate = Date().time
    return Date(Random.nextLong(0, currentDate))
}
