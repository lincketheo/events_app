package com.communeo.mobile.android.core.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.communeo.mobile.android.core.ui.navigation.AppDestination
import com.communeo.mobile.android.core.ui.navigation.BottomAppBarDestination
import com.communeo.mobile.android.core.ui.navigation.toAppDestination

/**
 * Gets the current app destination based on the current navigation
 * back stack
 *
 * @param navController The nav controller that is (ideally) memoized by
 * the caller
 */
@Composable
fun getCurrentDestinationOrStart(
    navController: NavHostController
): AppDestination {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination: AppDestination? = currentRoute?.toAppDestination()
    return currentDestination ?: BottomAppBarDestination.landingDestination
}
