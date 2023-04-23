package com.communeo.mobile.android.features.feed.ui.views.eventitem.actionbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.communeo.mobile.android.R

@Composable
fun RSVPScreen(
    closeRsvpScreen: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1.2f), text = "Going?", textAlign = TextAlign.Start
        )
        TextButton(
            modifier = Modifier.weight(0.9f),
            onClick = { closeRsvpScreen() },
        ) {
            Text(
                text = "Yes", textAlign = TextAlign.End
            )
        }
        TextButton(
            modifier = Modifier.weight(0.8f),
            onClick = { closeRsvpScreen() },
        ) {
            Text(
                text = "No", textAlign = TextAlign.End
            )
        }
        TextButton(
            modifier = Modifier.weight(1f),
            onClick = { closeRsvpScreen() },
        ) {
            Text(
                text = "Maybe", textAlign = TextAlign.End
            )
        }
        IconButton(modifier = Modifier.weight(0.5f), onClick = { closeRsvpScreen() }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = "hello",
            )
        }
    }
}
