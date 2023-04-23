package com.communeo.mobile.android.features.feed.ui.views.eventitem.actionbar

import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.communeo.mobile.android.R

@Composable
fun ShareScreen(
    onClose: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1.2f), text = "Share with", textAlign = TextAlign.Start
        )
        TextButton(
            modifier = Modifier.weight(0.9f),
            onClick = { onClose() },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_group_24),
                contentDescription = "Group CD"
            )
            Text(
                text = "Friend", textAlign = TextAlign.End
            )
        }

        /**
         * Share sheet intent
         */
        val context = LocalContext.current
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)

        TextButton(
            modifier = Modifier.weight(0.8f),
            onClick = {
                context.startActivity(shareIntent)
            },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_launch_24),
                contentDescription = "Group CD"
            )
            Text(
                text = "Other", textAlign = TextAlign.End
            )
        }
        IconButton(modifier = Modifier.weight(0.5f), onClick = { onClose() }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = "hello",
            )
        }
    }
}
