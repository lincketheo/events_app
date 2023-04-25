package com.communeo.mobile.android.features.business.events.data.models

data class EventHashTag(
    val hashTag: String,
) {
    companion object {
        fun random() =
            EventHashTag(
                listOf(
                    "cool",
                    "I-dont-know-what-this-tag-means",
                    "football",
                    "park",
                    "food",
                    "house-party",
                ).random()
            )
    }
}
