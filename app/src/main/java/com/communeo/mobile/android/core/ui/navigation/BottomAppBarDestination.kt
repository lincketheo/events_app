package com.communeo.mobile.android.core.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.communeo.mobile.android.R

/**
 * These are the routes supplied on the bottom app bar
 * [route] is the route supplied to a `navController`,
 * [titleResourceId] is the resource id for the text to display
 * (if anything) on the bottom app bar and the title on the
 * top app bar, [iconResourceId] is the resource id for the
 * icon to display in the bottom app bar. [navDescriptorId]
 * is the id to the string that will describe the icon in the bottom app
 * bar (for accessibility purposes)
 */
sealed class BottomAppBarDestination(
    route: String, // Doesn't need to be translated because it's used only internally
    @StringRes private val titleResourceId: Int,
    private val iconResourceId: Int,
    @StringRes private val navDescriptorId: Int,
) : AppDestination(route) {

    object Profile : BottomAppBarDestination(
        "profile",
        R.string.profile_route_label,
        R.drawable.profile_icon,
        R.string.profile_route_descriptor
    ) {
        override val bottomAppBarHighlight: BottomAppBarDestination = this@Profile
    }

    object Feed : BottomAppBarDestination(
        "feed",
        R.string.feed_route_label,
        R.drawable.feed_icon,
        R.string.feed_route_descriptor,
    ) {
        override val bottomAppBarHighlight: BottomAppBarDestination = this@Feed
    }

    object Search : BottomAppBarDestination(
        "search",
        R.string.search_route_label,
        R.drawable.baseline_search_24,
        R.string.search_route_description,
    ) {
        override val bottomAppBarHighlight: BottomAppBarDestination = this@Search
    }

    @Composable
    fun Title() {
        Text(stringResource(id = titleResourceId))
    }

    @Composable
    fun DestinationIcon() {
        Icon(
            painterResource(id = iconResourceId),
            stringResource(id = navDescriptorId)
        )
    }

    companion object {
        val instances = setOf(Feed, Search, Profile)
        val landingDestination = Feed
    }
}
