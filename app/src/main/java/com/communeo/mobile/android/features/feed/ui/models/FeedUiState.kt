package com.communeo.mobile.android.features.feed.ui.models

data class FeedUiState(
    val eventsShowing: List<FeedEventCardUiState>,
    val isLoading: Boolean,
) {
    companion object {
        val initial = FeedUiState(emptyList(), false)
    }
}
