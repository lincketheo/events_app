package com.communeo.common.data.models.event

import com.communeo.common.util.generateRandomDate
import com.communeo.common.util.generateRandomSentence
import com.communeo.common.data.models.user.PublicUser
import com.communeo.common.data.repository.impl.FakeUserRepository
import java.util.*

data class Event(
    val title: String,
    val shortDescription: String,
    val longDescription: String,
    val dateOccurring: Date,
    val organizer: PublicUser,
) {
    companion object {
        fun random(
            title: String? = null,
            shortDescription: String? = null,
            longDescription: String? = null,
            dateOccurring: Date? = null,
            organizer: PublicUser? = null,
        ): Event {
            return Event(
                title = title ?: generateRandomSentence(3),
                shortDescription = shortDescription ?: generateRandomSentence(10),
                longDescription = longDescription ?: generateRandomSentence(50),
                dateOccurring = dateOccurring ?: generateRandomDate(),
                organizer = organizer ?: FakeUserRepository.randomUser(),
            )
        }
    }
}
