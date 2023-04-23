package com.communeo.mobile.android.core.ui.components.semantics

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeTestRule

class FloatingActionButtonSemantics(private val composeTestRule: ComposeTestRule) {
    private fun text(): SemanticsNodeInteraction {
        return composeTestRule
            .onNode(hasTestTag("appFloatingActionButtonText"), useUnmergedTree = true)
    }

    private fun icon(): SemanticsNodeInteraction {
        return composeTestRule
            .onNode(hasTestTag("appFloatingActionButtonIcon"), useUnmergedTree = true)
    }

    fun assertMaximized() {
        text().assertExists()
    }

    fun assertMinimized() {
        text().assertDoesNotExist()
    }

    fun assertVisible() {
        icon().assertExists()
    }

    fun assertInvisible() {
        icon().assertDoesNotExist()
    }
}

fun ComposeTestRule.floatingActionButtonSemantics() = FloatingActionButtonSemantics(this)
