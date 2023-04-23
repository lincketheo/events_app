package com.communeo.mobile.android.core.ui

import androidx.navigation.NavHostController
import com.communeo.mobile.android.core.ui.navigation.BottomAppBarDestination
import com.communeo.mobile.android.util.BaseComposeRuleTest
import com.example.events.ui.models.common.BottomNavigationBarState
import com.example.events.ui.models.common.FloatingActionButtonState
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class AppNavigationHostUnitTest : BaseComposeRuleTest() {
    private lateinit var navController: NavHostController
    private lateinit var bottomNavigationBarState: BottomNavigationBarState
    private lateinit var floatingActionButtonState: FloatingActionButtonState

    @Before
    fun setup() {
        composeRule.setContent {
            navController = getNavController()

            AppNavigationHost(
                navController = navController,
                setFloatingActionButtonState = {
                    floatingActionButtonState = it
                },
                setBottomNavigationBarState = {
                    bottomNavigationBarState = it
                }
            )
        }
    }

    @Test
    fun starting_dest_is_feed() {
        Truth.assertThat(navController.currentBackStackEntry?.destination?.route)
            .isEqualTo(BottomAppBarDestination.Feed.route)
    }
}
