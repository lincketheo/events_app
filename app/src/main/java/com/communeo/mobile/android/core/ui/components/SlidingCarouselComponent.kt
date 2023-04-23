package com.communeo.mobile.android.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import java.net.URL

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SlidingCarouselWithImageURLS(
    modifier: Modifier = Modifier,
    urls: List<URL>,
) {
    SlidingCarousel(
        modifier = modifier,
        itemsCount = urls.size,
    ) { id ->
        AsyncImage(
            modifier = modifier.height(200.dp),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(LocalContext.current)
                .data(urls[id].toString())
                .build(),
            contentDescription = "Translated description of what the image contains"
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SlidingCarousel(
    modifier: Modifier = Modifier,
    pagerState: PagerState = remember { PagerState() },
    itemsCount: Int,
    itemContent: @Composable (index: Int) -> Unit,
) {
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        HorizontalPager(count = itemsCount, state = pagerState) { page ->
            itemContent(page)
        }

        if (itemsCount > 1) {
            Surface(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.BottomCenter),
                shape = CircleShape,
                color = Color.Black.copy(alpha = 0.5f)
            ) {
                DotsIndicator(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                    totalDots = itemsCount,
                    selectedIndex = if (isDragged) {
                        pagerState.currentPage
                    } else {
                        pagerState.currentPage
                    },
                    dotSize = 8.dp
                )
            }
        }
    }
}

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color = Color.Yellow,
    unSelectedColor: Color = Color.Gray,
    dotSize: Dp
) {
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        items(totalDots) { index ->
            IndicatorDot(
                color = if (index == selectedIndex) selectedColor else unSelectedColor,
                size = dotSize
            )

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Composable
fun IndicatorDot(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(color)
    )
}
