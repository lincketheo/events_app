package com.communeo.mobile.android.features.profile.ui.views.me

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.communeo.mobile.android.features.profile.ui.models.MyProfileState
import com.communeo.mobile.android.features.profile.ui.views.CustomTabRow

@Composable
fun MyProfileEntryPoint(
    myProfileState: MyProfileState,
    signOutAssuredly: () -> Unit,
    loadFriends: () -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .testTag("profileEntryPoint"),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Black, CircleShape),
            contentScale = ContentScale.Crop,
            model = myProfileState.user.publicUser.profilePictureUrl.toString(),
            contentDescription = "Translated description of what the image contains"
        )
        Text(
            text = myProfileState.user.publicUser.name,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )
        Button(onClick = signOutAssuredly) {
            Text("Sign out")
        }
        CustomTabRow(
            friendsContent = {
                MyFriendsList(
                    friends = myProfileState.loadedFriends,
                    pendingFriendsFromMe = myProfileState.loadedPendingFriendIRequested,
                    pendingFriendsToMe = myProfileState.loadedPendingFriendsRequestedToMe,
                    rejectedFriends = myProfileState.loadedRejectedFriends,
                )
            },
            calendarContent = {
                Text("Calendar")
            },
            onFriendsClicked = {
                loadFriends()
            },
        )
    }
}
