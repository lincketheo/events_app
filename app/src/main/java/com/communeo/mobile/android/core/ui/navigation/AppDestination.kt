package com.communeo.mobile.android.core.ui.navigation

abstract class AppDestination(val route: String) {
    /**
     * Checks if the current route matches the
     * specific app destination
     */
    open fun matches(route: String): Boolean {
        return this.route == route
    }
    abstract val bottomAppBarHighlight: BottomAppBarDestination
}

object AppDestinationFactory {
    private val destinations: Set<AppDestination> =
        BottomAppBarDestination.instances

    fun appDestinationFromRoute(route: String): AppDestination? {
        return try {
            destinations.first { it.matches(route) }
        } catch (exception: NoSuchElementException) {
            null
        }
    }
}

fun String.toAppDestination(): AppDestination? {
    return AppDestinationFactory.appDestinationFromRoute(this)
}
