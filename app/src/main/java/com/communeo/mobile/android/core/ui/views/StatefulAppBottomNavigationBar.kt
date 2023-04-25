package com.communeo.mobile.android.core.ui.views

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavHostController
import com.communeo.mobile.android.core.ui.models.BottomNavigationBarState
import com.communeo.mobile.android.core.ui.models.FloatingActionButtonState
import com.communeo.mobile.android.core.ui.navigation.BottomAppBarDestination
import com.communeo.mobile.android.core.ui.util.getCurrentDestinationOrStart

@Composable
fun StatefulAppBottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    setBottomNavigationBarState: (BottomNavigationBarState) -> Unit,
    setFloatingActionButtonState: (FloatingActionButtonState) -> Unit,
) {
    val currentDestination = getCurrentDestinationOrStart(navController = navController)
    val bottomAppBarDestinationToHighlight = currentDestination.bottomAppBarHighlight
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            modifier = Modifier.testTag("feedBottomAppBarButton"),
            icon = { BottomAppBarDestination.Feed.DestinationIcon() },
            label = { BottomAppBarDestination.Feed.Title() },
            selected = BottomAppBarDestination.Feed == bottomAppBarDestinationToHighlight,
            alwaysShowLabel = false,
            onClick = {
                setBottomNavigationBarState(BottomNavigationBarState.Visible)
                setFloatingActionButtonState(FloatingActionButtonState.Visible.Big)
                navController.navigate(BottomAppBarDestination.Feed.route) {
                    popUpTo(BottomAppBarDestination.landingDestination.route) {
                        inclusive = true
                    }
                }
            },
        )

        NavigationBarItem(
            modifier = Modifier.testTag("searchBottomAppBarButton"),
            icon = { BottomAppBarDestination.Search.DestinationIcon() },
            label = { BottomAppBarDestination.Search.Title() },
            selected = BottomAppBarDestination.Search == bottomAppBarDestinationToHighlight,
            alwaysShowLabel = false,
            onClick = {
                setBottomNavigationBarState(BottomNavigationBarState.Visible)
                setFloatingActionButtonState(FloatingActionButtonState.Invisible)
                navController.navigate(BottomAppBarDestination.Search.route) {
                    popUpTo(BottomAppBarDestination.landingDestination.route) {
                        inclusive = true
                    }
                }
            },
        )

        NavigationBarItem(
            modifier = Modifier.testTag("profileBottomAppBarButton"),
            icon = { BottomAppBarDestination.Profile.DestinationIcon() },
            label = { BottomAppBarDestination.Profile.Title() },
            selected = BottomAppBarDestination.Profile == bottomAppBarDestinationToHighlight,
            alwaysShowLabel = false,
            onClick = {
                setBottomNavigationBarState(BottomNavigationBarState.Visible)
                setFloatingActionButtonState(FloatingActionButtonState.Invisible)
                navController.navigate(BottomAppBarDestination.Profile.route) {
                    popUpTo(BottomAppBarDestination.landingDestination.route) {
                        inclusive = true
                    }
                }
            },
        )
    }
}
