package com.communeo.mobile.android.features.feed.ui.views.eventitem

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.communeo.mobile.android.core.ui.components.FadedExpandableText
import com.communeo.mobile.android.core.ui.components.SlidingCarouselWithImageURLS
import java.net.URL

@Composable
fun FeedItemImages(
    urls: List<URL>,
) {
    SlidingCarouselWithImageURLS(urls = urls)
}

@Composable
fun FeedItemContent(
    content: String,
    imageUrls: List<URL>,
) {
    Column {
        FeedItemImages(imageUrls)
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = "Description:",
            style = MaterialTheme.typography.labelMedium,
        )
        Divider()

        val bodyLineCount by remember(content) { mutableStateOf(0) }
        var expanded by remember { mutableStateOf(false) }

        var descriptionExpanded = bodyLineCount > 2
        val modifier = Modifier.padding(top = 12.dp)

        if (bodyLineCount > 2) {
            modifier
                .animateContentSize()
                .graphicsLayer { alpha = 0.99f }
                .drawWithContent {
                    val colors = listOf(Color.Black, Color.Transparent)
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(colors),
                        blendMode = BlendMode.DstIn
                    )
                }
        } else {
            Modifier
                .padding(top = 12.dp)
        }

        Box(modifier = Modifier.animateContentSize()) {
            FadedExpandableText(content = content)
        }
    }
}
