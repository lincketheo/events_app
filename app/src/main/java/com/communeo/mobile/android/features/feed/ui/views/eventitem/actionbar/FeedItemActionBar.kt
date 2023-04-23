package com.communeo.mobile.android.features.feed.ui.views.eventitem.actionbar

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.communeo.mobile.android.R
import com.communeo.mobile.android.features.feed.ui.models.CommentUiState
import com.example.events.ui.models.common.FloatingActionButtonState

@Composable
fun FeedItemActionBar(
    setFloatingActionButtonState: (FloatingActionButtonState) -> Unit,
    comments: List<CommentUiState>?,
) {
    var rsvpOptionsShown by remember { mutableStateOf(false) }
    var commentOptionShown by remember { mutableStateOf(false) }
    var shareOptionShown by remember { mutableStateOf(false) }
    val noneShown = !(rsvpOptionsShown || commentOptionShown || shareOptionShown)

    /**
     * This might be overkill, TODO - Think about it
     */
    val onRSVPClicked = {
        rsvpOptionsShown = true
        commentOptionShown = false
        shareOptionShown = false
    }
    val onCommentClicked = {
        setFloatingActionButtonState(FloatingActionButtonState.Invisible)
        rsvpOptionsShown = false
        commentOptionShown = true
        shareOptionShown = false
    }
    val onShareClicked = {
        rsvpOptionsShown = false
        commentOptionShown = false
        shareOptionShown = true
    }
    val reset = {
        rsvpOptionsShown = false
        commentOptionShown = false
        shareOptionShown = false
    }

    Box(
        Modifier
            .fillMaxWidth()
    ) {
        /**
         * Action Bar
         */
        AnimatedVisibility(
            visible = noneShown,
            enter = slideInHorizontally() + fadeIn(),
            exit = slideOutHorizontally() + fadeOut(),
        ) {
            ActionBar(
                onClickRsvp = onRSVPClicked,
                onClickComment = onCommentClicked,
                onClickedShare = onShareClicked,
            )
        }
        /**
         * RSVP Screen
         */
        AnimatedVisibility(
            visible = rsvpOptionsShown,
            enter = slideInHorizontally() + fadeIn(),
            exit = slideOutHorizontally() + fadeOut(),
        ) {
            RSVPScreen(reset)
        }

        /**
         * Comment Screen
         */
        AnimatedVisibility(
            visible = commentOptionShown,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut(),
        ) {
            CommentScreen(
                closeCommentScreen = {
                    setFloatingActionButtonState(FloatingActionButtonState.Visible.Small)
                    reset()
                },
                comments = comments ?: emptyList()
            )
        }

        /**
         * Share Screen
         */
        AnimatedVisibility(
            visible = shareOptionShown,
            enter = slideInHorizontally { -it / 2 } + fadeIn(),
            exit = slideOutHorizontally { -it / 2 } + fadeOut(),
        ) {
            ShareScreen(reset)
        }
    }
}

@Composable
private fun ActionBar(
    onClickRsvp: () -> Unit,
    onClickComment: () -> Unit,
    onClickedShare: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = onClickedShare
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_share_24),
                    contentDescription = "abc"
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = onClickComment,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_comment_24),
                    contentDescription = "abc"
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = onClickRsvp
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_send_24),
                    contentDescription = "abc"
                )
            }
        }
    }
}
