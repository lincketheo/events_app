package com.communeo.mobile.android.core.ui.components.semantics

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeTestRule

class AppBottomNavigationBarSemantics(private val composeTestRule: ComposeTestRule) {
    fun feedButton(): SemanticsNodeInteraction {
        return composeTestRule.onNode(hasTestTag("feedBottomAppBarButton"))
    }
    fun searchButton(): SemanticsNodeInteraction {
        return composeTestRule.onNode(hasTestTag("searchBottomAppBarButton"))
    }
    fun profileButton(): SemanticsNodeInteraction {
        return composeTestRule.onNode(hasTestTag("profileBottomAppBarButton"))
    }
    fun assertVisible() {
        composeTestRule
            .onNode(hasTestTag("profileBottomAppBarButton"))
            .assertExists()
    }
}

fun ComposeTestRule.appBottomBarSemantics() = AppBottomNavigationBarSemantics(this)
