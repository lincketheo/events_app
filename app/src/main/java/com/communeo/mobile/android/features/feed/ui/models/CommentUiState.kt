package com.communeo.mobile.android.features.feed.ui.models

import com.communeo.common.data.models.feed.comments.CommentContent

data class CommentUiState(
    val content: CommentContent,
    val subCommentsShown: Set<SubCommentUiState>? = null,
)