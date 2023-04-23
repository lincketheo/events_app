package com.communeo.mobile.android.features.profile.ui.views

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.communeo.common.data.models.user.AuthenticatedUser
import com.communeo.mobile.android.R

@Composable
fun ProfileEntryPoint(
    user: AuthenticatedUser,
    signOut: () -> Unit,
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
            model = user.publicUser.profilePictureUrl.toString(),
            contentDescription = "Translated description of what the image contains"
        )
        Text(
            text = user.publicUser.name,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )
        Button(onClick = signOut) {
            Text("Sign out")
        }
        CustomTabRow()
    }
}

enum class ProfileTab(val title: String, val iconId: Int) {
    Calendar("Calendar", R.drawable.baseline_event_24),
    Friends("Friends", R.drawable.baseline_people_24)
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CustomTabRow() {
    var state by remember { mutableStateOf(0) }
    val tabs = ProfileTab.values()

    Column {
        TabRow(selectedTabIndex = state) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = {
                        Row {
                            Icon(
                                painter = painterResource(id = tab.iconId),
                                contentDescription = "lakjds"
                            )
                            Text(text = tab.title, maxLines = 1, overflow = TextOverflow.Ellipsis)
                        }
                    }
                )
            }
        }
        AnimatedContent(targetState = state) { state ->
            when (tabs[state]) {
                ProfileTab.Calendar -> Text("Calendar")
                ProfileTab.Friends -> Text("Friends")
            }
        }
    }
}
