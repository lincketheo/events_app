package com.communeo.mobile.android.features.feed.ui.models

import com.communeo.mobile.android.features.business.comments.data.models.CommentContent

data class CommentUiState(
    val content: CommentContent,
    val subCommentsShown: Set<SubCommentUiState>? = null,
)
