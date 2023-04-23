package com.communeo.mobile.android.features.feed.ui.views.eventitem

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.communeo.common.data.models.user.PublicUser

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
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Box(
                modifier = Modifier
                    .padding(end = 12.dp, top = 6.dp, bottom = 6.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, CircleShape),
                    contentScale = ContentScale.Crop,
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(organizer.profilePictureUrl.toString())
                        .build(),
                    contentDescription = null,
                )
            }
            Text(
                text = "Organizer: ",
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = organizer.name,
                style = MaterialTheme.typography.labelMedium
            )
        }
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
