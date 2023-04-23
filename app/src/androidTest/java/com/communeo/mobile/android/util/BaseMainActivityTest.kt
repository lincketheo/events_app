package com.communeo.mobile.android.util

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.communeo.mobile.android.MainActivity
import org.junit.Rule

class BaseMainActivityTest : BaseInstrumentedTest() {
    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()
}
