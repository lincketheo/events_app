package com.communeo.mobile.android.features.feed.ui.views.eventitem

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.communeo.mobile.android.core.ui.models.FloatingActionButtonState
import com.communeo.mobile.android.features.feed.ui.models.FeedEventCardUiState
import com.communeo.mobile.android.features.feed.ui.views.eventitem.actionbar.FeedItemActionBar

@Composable
fun FeedItem(
    eventUiState: FeedEventCardUiState,
    setFloatingActionButtonState: (FloatingActionButtonState) -> Unit,
) {
    Column {
        FeedTitle(
            title = eventUiState.event.title,
            organizer = eventUiState.event.organizer,
            date = eventUiState.event.dateOccurring.toString(),
        )
        FeedItemContent(
            content = eventUiState.event.longDescription,
            imageUrls = eventUiState.event.images.map { it.imageURL },
        )
        FeedItemActionBar(
            setFloatingActionButtonState = setFloatingActionButtonState,
            eventUiState.commentsShown,
        )
    }
}
