package com.communeo.mobile.android.features.feed.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.communeo.mobile.android.core.ui.util.fullyVisibleIndices
import com.communeo.mobile.android.core.ui.util.isScrollingUp
import com.communeo.mobile.android.features.feed.ui.models.FeedUiState
import com.communeo.mobile.android.features.feed.ui.viewmodels.PagingFeedViewModel
import com.communeo.mobile.android.features.feed.ui.views.eventitem.FeedItem
import com.example.events.ui.models.common.BottomNavigationBarState
import com.example.events.ui.models.common.FloatingActionButtonState

@Composable
fun FeedEntryPoint(
    viewModel: PagingFeedViewModel,
    setBottomNavigationBarState: (BottomNavigationBarState) -> Unit,
    setFloatingActionButtonState: (FloatingActionButtonState) -> Unit,
) {
    val feedUiState by viewModel.uiState.collectAsState()
    val lazyListState = rememberLazyListState()

    /**
     * Derived from lazyListState
     */
    val isScrollingUp = lazyListState.isScrollingUp()
    val fullyVisibleIndices = lazyListState.fullyVisibleIndices()

    /**
     * Hides/Minimizes or Displays/Maximizes the bab/fab
     * on Scroll up/down (Respectively)
     */
    LaunchedEffect(key1 = isScrollingUp) {
        if (lazyListState.isScrollInProgress) {
            if (isScrollingUp) {
                setFloatingActionButtonState(FloatingActionButtonState.Visible.Big)
                setBottomNavigationBarState(BottomNavigationBarState.Visible)
            } else {
                setFloatingActionButtonState(FloatingActionButtonState.Visible.Small)
                setBottomNavigationBarState(BottomNavigationBarState.Invisible)
            }
        }
    }

    /**
     * Tells ViewModel that these items are fully on screen
     */
    LaunchedEffect(key1 = fullyVisibleIndices) {
        if (fullyVisibleIndices.isEmpty()) {
            viewModel.consume(0)
        } else {
            viewModel.consume(fullyVisibleIndices.max())
        }
    }

    StatefulLazyListFeed(
        lazyListState = lazyListState,
        feedUiState = feedUiState,
        setFloatingActionButtonState = setFloatingActionButtonState
    )
}

@Composable
fun StatefulLazyListFeed(
    lazyListState: LazyListState,
    feedUiState: FeedUiState,
    setFloatingActionButtonState: (FloatingActionButtonState) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.testTag("feedEntryPoint"),
        state = lazyListState
    ) {
        items(feedUiState.eventsShowing.size) { eventId ->

            val eventUiState = feedUiState.eventsShowing[eventId]

            Column(Modifier.padding(bottom = 12.dp)) {
                FeedItem(
                    eventUiState = eventUiState,
                    setFloatingActionButtonState = setFloatingActionButtonState,
                )
                Divider(thickness = 3.dp)
            }
        }

        if (feedUiState.isLoading) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}
