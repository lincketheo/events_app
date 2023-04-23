package com.communeo.mobile.android.features.search.ui.views.semantics

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeTestRule

class SearchEntryPointSemantics(private val composeTestRule: ComposeTestRule) {
    fun assertOnSearchPage() {
        composeTestRule
            .onNode(hasTestTag("searchEntryPoint"))
            .assertExists()
    }
}

fun ComposeTestRule.searchEntryPointSemantics() = SearchEntryPointSemantics(this)
