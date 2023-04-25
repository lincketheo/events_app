package com.communeo.mobile.android.features.business.events.data.models

data class EventLocation(
    val latitudeDegrees: Double,
    val longitudeDegrees: Double,
) {
    companion object {
        fun random() = listOf(
            EventLocation(40.036204, -105.311755),
            EventLocation(42.547282, -107.001639),
            EventLocation(36.663199, -95.045252),
            EventLocation(36.671911, -94.907651),
            EventLocation(34.792206, -112.091644),
        ).random()
    }
}
