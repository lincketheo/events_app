package com.communeo.mobile.android.core.ui.components

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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.communeo.common.data.models.user.PublicUser

@Composable
fun UserHorizontalBarItem(
    organizer: PublicUser,
    trailingText: (name: String) -> String = { it },
    rightJustifiedContent: @Composable () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
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
                text = trailingText(organizer.name),
                style = MaterialTheme.typography.labelMedium
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
        ) {
            rightJustifiedContent()
        }
    }
}
