package com.communeo.common.data.models.event.comments

import com.communeo.common.data.models.event.Event

data class Comment(
    val parentEvent: Event,
    val content: CommentContent
) {
    companion object {
        fun random(
            parentEvent: Event? = null,
            content: CommentContent? = null,
        ) : Comment {
            return Comment(
                parentEvent = parentEvent ?: Event.random(),
                content = content ?: CommentContent.random()
            )
        }
    }
}
