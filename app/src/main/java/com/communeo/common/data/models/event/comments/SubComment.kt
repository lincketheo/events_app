package com.communeo.common.data.models.event.comments

data class SubComment(
    val parentComment: Comment,
    val content: CommentContent,
) {
    companion object {
        fun random(
            parentComment: Comment? = null,
            content: CommentContent? = null,
        ) : SubComment {
            return SubComment(
                parentComment = parentComment ?: Comment.random(),
                content = content ?: CommentContent.random(),
            )
        }
    }
}
