package com.communeo.mobile.android.features.business.events.data.models

import java.net.URL
import kotlin.random.Random

data class EventImage(
    val imageURL: URL,
) {
    companion object {
        fun random() = EventImage(
            URL(
                "https://picsum.photos/${Random.nextInt(100, 500)}/${Random.nextInt(100, 500)}"
            )
        )
    }
}
