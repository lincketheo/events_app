package com.communeo.mobile.android.features.feed.ui.views.eventitem.actionbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.communeo.common.data.models.feed.comments.CommentContent
import com.communeo.mobile.android.R
import com.communeo.mobile.android.features.feed.ui.models.CommentUiState
import java.lang.StrictMath.min

@Composable
fun CommentScreen(
    closeCommentScreen: () -> Unit,
    comments: List<CommentUiState>,
) {
    Box(
        Modifier
            .fillMaxWidth(),
    ) {
        Column(
            Modifier.fillMaxWidth(),
        ) {
            var commentText by remember {
                mutableStateOf("")
            }
            CommentTitle(closeCommentScreen)
            CommentsList(comments = comments)
            CommentEnterText(
                currentCommentText = commentText,
                onCommentTextChange = { commentText = it }
            )
            CommentSubmit(
                onSubmit = {}
            )
        }
    }
}

@Composable
fun CommentsList(
    comments: List<CommentUiState>
) {
    Column {
        comments.forEach { parent ->
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Comment(parent.content)
                parent.subCommentsShown?.forEach { child ->
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp)
                            .padding(vertical = 2.dp)
                    ) {
                        Comment(child.content)
                    }
                }
            }
        }
    }
}

@Composable
fun Comment(
    content: CommentContent
) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = content.owner.name,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = content.content,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun CommentEnterText(
    currentCommentText: String,
    onCommentTextChange: (String) -> Unit,
    maxChars: Int = 50,
) {
    // Trim the string length to maxChars
    val displayCommentText = currentCommentText
        .substring(0, min(currentCommentText.length, maxChars))
    val currentSize = displayCommentText.length

    Text(
        text = "${displayCommentText.length} / $maxChars",
        modifier = Modifier.fillMaxWidth(),
        color = if (currentSize > 0.8 * maxChars) {
            MaterialTheme.colorScheme.error
        } else {
            MaterialTheme.colorScheme.onSurface
        },
        style = MaterialTheme.typography.labelSmall,
        fontWeight = if (currentSize > 0.8 * maxChars) {
            FontWeight.Bold
        } else {
            FontWeight.Normal
        },
        textAlign = TextAlign.End,
    )
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = displayCommentText,
        onValueChange = onCommentTextChange,
    )
}

@Composable
fun CommentTitle(
    closeCommentScreen: () -> Unit
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
    ) {
        Text(
            text = "Comments",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold
        )
        Icon(
            modifier = Modifier
                .padding(0.dp)
                .clickable { closeCommentScreen() },
            painter = painterResource(
                id = R.drawable.baseline_close_24
            ),
            contentDescription = "close"
        )
    }
}

@Composable
fun CommentSubmit(
    onSubmit: () -> Unit
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
    ) {
        Button(onClick = { onSubmit() }) {
            Text("Submit")
        }
    }
}
