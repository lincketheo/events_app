package com.communeo.mobile.android.features.business.events.data.source.network.models

import com.communeo.mobile.android.features.business.events.data.models.Event

typealias EventResponse = Event

fun EventResponse.toEvent(): Event {
    return this
}
