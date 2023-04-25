package com.communeo.mobile.android.core.ui.components

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertHasClickAction
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.communeo.mobile.android.core.ui.components.semantics.appBottomBarSemantics
import com.communeo.mobile.android.core.ui.models.BottomNavigationBarState
import com.communeo.mobile.android.core.ui.models.FloatingActionButtonState
import com.communeo.mobile.android.core.ui.views.StatefulAppBottomNavigationBar
import com.communeo.mobile.android.util.BaseComposeRuleTest
import org.junit.Before
import org.junit.Test

class AppBottomNavigationBarUnitTest : BaseComposeRuleTest() {
    private lateinit var navController: NavHostController
    private lateinit var bottomNavigationBarState: BottomNavigationBarState
    private lateinit var floatingActionButtonState: FloatingActionButtonState

    @Before
    fun setup() {
        composeRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())

            bottomNavigationBarState = BottomNavigationBarState.Visible
            floatingActionButtonState = FloatingActionButtonState.Visible.Big

            StatefulAppBottomNavigationBar(
                navController = navController,
                setBottomNavigationBarState = { bottomNavigationBarState = it },
                setFloatingActionButtonState = { floatingActionButtonState = it },
            )
        }
    }

    @Test
    fun three_buttons_show_on_screen() {
        composeRule
            .appBottomBarSemantics()
            .feedButton()
            .assertHasClickAction()
        composeRule
            .appBottomBarSemantics()
            .searchButton()
            .assertHasClickAction()
        composeRule
            .appBottomBarSemantics()
            .profileButton()
            .assertHasClickAction()
    }
}
