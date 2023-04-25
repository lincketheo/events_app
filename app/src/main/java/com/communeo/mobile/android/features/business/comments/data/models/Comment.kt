package com.communeo.mobile.android.features.business.comments.data.models

import com.communeo.mobile.android.features.business.events.data.models.Event
import kotlin.random.Random
import kotlin.random.nextULong
import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val id: ULong,
    val parentEventId: ULong,
    val content: CommentContent
) {
    companion object {
        fun random(
            id: ULong? = null,
            parentEventId: ULong? = null,
            content: CommentContent? = null,
        ): Comment {
            return Comment(
                id = id ?: Random.nextULong(),
                parentEventId = parentEventId ?: Event.random().id,
                content = content ?: CommentContent.random()
            )
        }
    }
}
