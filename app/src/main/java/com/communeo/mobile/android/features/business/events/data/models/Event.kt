package com.communeo.mobile.android.features.business.events.data.models

import com.communeo.mobile.android.core.util.generateRandomInstant
import com.communeo.mobile.android.core.util.generateRandomSentence
import com.communeo.mobile.android.features.business.users.data.models.PublicUser
import kotlin.random.Random
import kotlin.random.nextULong
import kotlinx.datetime.Instant

data class Event(
    val id: ULong,
    val title: String,
    val shortDescription: String,
    val longDescription: String,
    val dateOccurring: Instant,
    val organizer: PublicUser,
    val tags: Set<EventTag>,
    val hashTags: Set<EventHashTag>,
    val images: Set<EventImage>,
    val meetingSpot: EventLocation,
) {
    companion object {
        fun random(
            id: ULong? = null,
            title: String? = null,
            shortDescription: String? = null,
            longDescription: String? = null,
            dateOccurring: Instant? = null,
            organizer: PublicUser? = null,
            tags: Set<EventTag>? = null,
            hasTags: Set<EventHashTag>? = null,
            images: Set<EventImage>? = null,
            meetingSpot: EventLocation? = null,
        ): Event {
            return Event(
                id = id ?: Random.nextULong(),
                title = title ?: generateRandomSentence(3),
                shortDescription = shortDescription ?: generateRandomSentence(10),
                longDescription = longDescription ?: generateRandomSentence(50),
                dateOccurring = dateOccurring ?: generateRandomInstant(),
                organizer = organizer ?: PublicUser.random(),
                tags = tags ?: (0..Random.nextInt(0, 5))
                    .map { EventTag.random() }.toSet(),
                hashTags = hasTags ?: (0..Random.nextInt(0, 10))
                    .map { EventHashTag.random() }.toSet(),
                images = images ?: (1..Random.nextInt(0, 5))
                    .map { EventImage.random() }
                    .toSet(), // TODO - map default if 0
                meetingSpot = meetingSpot ?: EventLocation.random(),
            )
        }
    }
}
