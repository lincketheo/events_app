package com.communeo.mobile.android.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import org.junit.Rule

open class BaseComposeRuleTest : BaseInstrumentedTest() {
    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    @Composable
    fun getNavController(): NavHostController {
        val navController = TestNavHostController(LocalContext.current)
        navController.navigatorProvider.addNavigator(ComposeNavigator())
        return navController
    }
}
