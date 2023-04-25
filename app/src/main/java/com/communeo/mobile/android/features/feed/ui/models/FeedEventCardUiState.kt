package com.communeo.mobile.android.features.feed.ui.models

import com.communeo.mobile.android.features.business.events.data.models.Event

data class FeedEventCardUiState(
    val event: Event,
    val commentsShown: List<CommentUiState>? = null,
) {
    companion object {
        fun initial(event: Event) = FeedEventCardUiState(event, emptyList())
    }
}
