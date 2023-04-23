package com.communeo.mobile.android.core.ui

import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import com.communeo.mobile.android.core.ui.components.semantics.appBottomBarSemantics
import com.communeo.mobile.android.core.ui.components.semantics.floatingActionButtonSemantics
import com.communeo.mobile.android.core.ui.navigation.BottomAppBarDestination
import com.communeo.mobile.android.features.feed.ui.views.semantics.feedEntryPointSemantics
import com.communeo.mobile.android.features.profile.ui.views.semantics.profileEntryPointSemantics
import com.communeo.mobile.android.features.search.ui.views.semantics.searchEntryPointSemantics
import com.communeo.mobile.android.util.BaseComposeRuleTest
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

/**
 * Tests that navigating using the bottom nav bar works
 * as expected
 */
class BottomAppBarNavigationUnitTests : BaseComposeRuleTest() {
    private lateinit var navController: NavHostController

    @Before
    fun setup() {
        composeRule.setContent {
            navController = getNavController()

            StatefulAppLayout(
                navController = navController,
            )
        }
    }

    @Test
    fun navigate_away_from_feed_back_to_feed() {
        composeRule
            .appBottomBarSemantics()
            .profileButton()
            .performClick()
        composeRule
            .appBottomBarSemantics()
            .feedButton()
            .performClick()

        Truth.assertThat(navController.currentBackStackEntry?.destination?.route)
            .isEqualTo(BottomAppBarDestination.Feed.route)
        composeRule
            .feedEntryPointSemantics()
            .assertOnFeedPage()
    }

    @Test
    fun press_profile_nav_feed() {
        composeRule
            .appBottomBarSemantics()
            .profileButton()
            .performClick()

        Truth.assertThat(navController.currentBackStackEntry?.destination?.route)
            .isEqualTo(BottomAppBarDestination.Profile.route)
        composeRule
            .profileEntryPointSemantics()
            .assertOnProfilePage()
    }

    @Test
    fun press_search_nav_feed() {
        composeRule
            .appBottomBarSemantics()
            .searchButton()
            .performClick()

        Truth.assertThat(navController.currentBackStackEntry?.destination?.route)
            .isEqualTo(BottomAppBarDestination.Search.route)
        composeRule
            .searchEntryPointSemantics()
            .assertOnSearchPage()
    }

    @Test
    fun profile_no_fab_yes_bab() {
        composeRule
            .appBottomBarSemantics()
            .profileButton()
            .performClick()

        composeRule
            .floatingActionButtonSemantics()
            .assertInvisible()
        composeRule
            .appBottomBarSemantics()
            .assertVisible()
    }

    @Test
    fun search_no_fab_yes_bab() {
        composeRule
            .appBottomBarSemantics()
            .searchButton()
            .performClick()

        composeRule
            .floatingActionButtonSemantics()
            .assertInvisible()
        composeRule
            .appBottomBarSemantics()
            .assertVisible()
    }

    @Test
    fun feed_max_fab_yes_bab() {
        composeRule
            .appBottomBarSemantics()
            .feedButton()
            .performClick()

        composeRule
            .floatingActionButtonSemantics()
            .assertVisible()
        composeRule
            .floatingActionButtonSemantics()
            .assertMaximized()
        composeRule
            .appBottomBarSemantics()
            .assertVisible()
    }
}
