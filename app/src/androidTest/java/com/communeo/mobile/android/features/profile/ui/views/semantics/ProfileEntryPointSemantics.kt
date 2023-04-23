package com.communeo.mobile.android.features.profile.ui.views.semantics

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeTestRule

class ProfileEntryPointSemantics(private val composeTestRule: ComposeTestRule) {
    fun assertOnProfilePage() {
        composeTestRule
            .onNode(hasTestTag("profileEntryPoint"))
            .assertExists()
    }
}

fun ComposeTestRule.profileEntryPointSemantics() = ProfileEntryPointSemantics(this)
