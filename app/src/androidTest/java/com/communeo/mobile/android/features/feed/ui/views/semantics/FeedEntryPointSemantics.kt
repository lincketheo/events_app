package com.communeo.mobile.android.features.feed.ui.views.semantics

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeTestRule

class FeedEntryPointSemantics(private val composeTestRule: ComposeTestRule) {
    fun assertOnFeedPage() {
        composeTestRule
            .onNode(hasTestTag("feedEntryPoint"))
            .assertExists()
    }
}

fun ComposeTestRule.feedEntryPointSemantics() = FeedEntryPointSemantics(this)
