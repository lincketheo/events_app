package com.communeo.mobile.android.core.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.communeo.common.data.models.user.AuthenticatedUser
import com.communeo.mobile.android.core.ui.navigation.BottomAppBarDestination
import com.communeo.mobile.android.features.feed.ui.viewmodels.PagingFeedViewModel
import com.communeo.mobile.android.features.feed.ui.views.FeedEntryPoint
import com.communeo.mobile.android.features.profile.ui.views.ProfileEntryPoint
import com.communeo.mobile.android.features.search.ui.viewmodels.SearchViewModel
import com.communeo.mobile.android.features.search.ui.views.SearchEntryPoint
import com.example.events.ui.models.common.BottomNavigationBarState
import com.example.events.ui.models.common.FloatingActionButtonState

@Composable
fun AppNavigationHost(
    navController: NavHostController,
    setFloatingActionButtonState: (FloatingActionButtonState) -> Unit,
    setBottomNavigationBarState: (BottomNavigationBarState) -> Unit,
    authenticatedUser: AuthenticatedUser,
    signOut: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = BottomAppBarDestination.landingDestination.route
    ) {
        composable(route = BottomAppBarDestination.Profile.route) {
            ProfileEntryPoint(
                user = authenticatedUser,
                signOut = signOut,
            )
        }
        composable(route = BottomAppBarDestination.Feed.route) {
            val feedViewModel: PagingFeedViewModel = hiltViewModel()
            FeedEntryPoint(
                feedViewModel,
                setFloatingActionButtonState = setFloatingActionButtonState,
                setBottomNavigationBarState = setBottomNavigationBarState,
            )
        }
        composable(route = BottomAppBarDestination.Search.route) {
            val searchViewModel: SearchViewModel = hiltViewModel()
            SearchEntryPoint(
                searchViewModel = searchViewModel,
            )
        }
    }
}
