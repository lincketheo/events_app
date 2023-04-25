package com.communeo.mobile.android.features.business.events.data.models

enum class EventType(val title: String) {
    ATHLETIC("Athletic"),
    TECHNOLOGY("Technology"),
    BUSINESS("Business"),
    SOCIAL("Social"),
    STRANGERS("Strangers"),
}

data class EventTag(
    val eventType: EventType,
) {
    companion object {
        fun random() = EventTag(EventType.values().random())
    }
}
