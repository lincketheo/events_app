package com.communeo.mobile.android.features.feed.ui.views.eventitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.communeo.mobile.android.core.ui.components.UserHorizontalBarItem
import com.communeo.mobile.android.features.business.users.data.models.PublicUser

@Composable
fun FeedTitle(
    title: String,
    organizer: PublicUser,
    date: String,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background),
    ) {
        UserHorizontalBarItem(organizer, trailingText = { "Organizer: $it" })
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.padding(vertical = 3.dp),
        ) {
            Text("Date: ", style = MaterialTheme.typography.labelSmall)
            Text(
                text = date,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}
