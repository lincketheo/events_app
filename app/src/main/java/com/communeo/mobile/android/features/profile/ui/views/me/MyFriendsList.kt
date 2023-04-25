package com.communeo.mobile.android.features.profile.ui.views.me

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import com.communeo.mobile.android.R
import com.communeo.mobile.android.core.ui.components.RowOfToggleableTagsWithCheckMarks
import com.communeo.mobile.android.core.ui.components.ToggleableTag
import com.communeo.mobile.android.core.ui.components.UserHorizontalBarItem
import com.communeo.mobile.android.features.business.users.data.models.PublicUser

@Composable
fun MyFriendsList(
    friends: List<PublicUser>,
    pendingFriendsFromMe: List<PublicUser>,
    pendingFriendsToMe: List<PublicUser>,
    rejectedFriends: List<PublicUser>,
) {
    /**
     * Gross.
     * It's 12:10 am and I'm tired and this is ugly
     */
    var myFriendsTagSelected by remember {
        mutableStateOf(true)
    }
    var pendingTagSelected by remember {
        mutableStateOf(false)
    }
    var rejectedTagSelected by remember {
        mutableStateOf(false)
    }

    Column {
        RowOfToggleableTagsWithCheckMarks(
            toggleableTags = listOf(
                ToggleableTag(
                    title = "My Friends",
                    isSelected = myFriendsTagSelected,
                    onClick = {
                        myFriendsTagSelected = true
                        pendingTagSelected = false
                        rejectedTagSelected = false
                    },
                ),
                ToggleableTag(
                    title = "Pending",
                    isSelected = pendingTagSelected,
                    onClick = {
                        myFriendsTagSelected = false
                        pendingTagSelected = true
                        rejectedTagSelected = false
                    },
                ),
                ToggleableTag(
                    title = "Rejected",
                    isSelected = rejectedTagSelected,
                    onClick = {
                        myFriendsTagSelected = false
                        pendingTagSelected = false
                        rejectedTagSelected = true
                    },
                )
            )
        )
        AnimatedVisibility(visible = myFriendsTagSelected) {
            LazyColumn {
                items(friends.size) {
                    UserHorizontalBarItem(organizer = friends[it])
                }
            }
        }
        AnimatedVisibility(visible = pendingTagSelected) {
            PendingLazyList(
                pendingToMe = pendingFriendsToMe.toSet(),
                pendingFromMe = pendingFriendsFromMe.toSet(),
            )
        }
        AnimatedVisibility(visible = rejectedTagSelected) {
            RejectedLazyList(rejectedFriends = rejectedFriends)
        }
    }
}

@Composable
fun PendingLazyList(
    pendingToMe: Set<PublicUser>,
    pendingFromMe: Set<PublicUser>,
) {
    var toMeTagSelected by remember {
        mutableStateOf(true)
    }
    var fromMeSelected by remember {
        mutableStateOf(true)
    }

    val toDisplay = if (toMeTagSelected && !fromMeSelected) {
        pendingToMe.toList()
    } else if (fromMeSelected && !toMeTagSelected) {
        pendingFromMe.toList()
    } else {
        (pendingToMe + pendingFromMe).toList()
    }
    Column {
        RowOfToggleableTagsWithCheckMarks(
            toggleableTags = listOf(
                ToggleableTag(
                    title = "To Me",
                    isSelected = toMeTagSelected,
                    onClick = {
                        if (fromMeSelected) {
                            toMeTagSelected = !toMeTagSelected
                        }
                    },
                ),
                ToggleableTag(
                    title = "From Me",
                    isSelected = fromMeSelected,
                    onClick = {
                        if (toMeTagSelected) {
                            fromMeSelected = !fromMeSelected
                        }
                    },
                ),
            )
        )
        LazyColumn {
            items(toDisplay.size) {
                UserHorizontalBarItem(organizer = toDisplay[it]) {
                    if (toDisplay[it] in pendingToMe) {
                        Row {
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.baseline_group_add_24
                                ),
                                contentDescription = null
                            )
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.baseline_group_remove_24
                                ),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RejectedLazyList(
    rejectedFriends: List<PublicUser>,
) {
    Column {
        Text("Showing friends you rejected for the past week")
        LazyColumn {
            items(rejectedFriends.size) {
                UserHorizontalBarItem(organizer = rejectedFriends[it])
            }
        }
    }
}
