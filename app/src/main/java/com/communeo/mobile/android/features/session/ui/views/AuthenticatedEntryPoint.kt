package com.communeo.mobile.android.features.session.ui.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.communeo.mobile.android.core.ui.StatefulAppLayout

@Composable
fun AuthenticatedEntryPoint(
    navController: NavHostController = rememberNavController()
) {
    StatefulAppLayout(
        navController = navController,
    )
}
