package com.communeo.mobile.android.core.ui.views

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.communeo.mobile.android.core.ui.models.BottomNavigationBarState
import com.communeo.mobile.android.core.ui.models.FloatingActionButtonState

@Composable
fun StatefulAppLayout(
    navController: NavHostController,
) {
    var floatingActionButtonState by remember {
        mutableStateOf<FloatingActionButtonState>(FloatingActionButtonState.Visible.Big)
    }
    var bottomNavigationBarState by remember {
        mutableStateOf<BottomNavigationBarState>(BottomNavigationBarState.Visible)
    }

    /**
     * Change state of the action bars
     */
    val setBottomNavigationBarState: (BottomNavigationBarState) -> Unit =
        { bottomNavigationBarState = it }
    val setFloatingActionButtonState: (FloatingActionButtonState) -> Unit =
        { floatingActionButtonState = it }

    StatelessAppLayout(
        navController = navController,
        floatingActionButtonState = floatingActionButtonState,
        bottomNavigationBarState = bottomNavigationBarState,
        setFloatingActionButtonState = setFloatingActionButtonState,
        setBottomNavigationBarState = setBottomNavigationBarState,
    )
}

@Composable
fun StatelessAppLayout(
    navController: NavHostController,
    floatingActionButtonState: FloatingActionButtonState,
    bottomNavigationBarState: BottomNavigationBarState,
    setFloatingActionButtonState: (FloatingActionButtonState) -> Unit,
    setBottomNavigationBarState: (BottomNavigationBarState) -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            AnimatedVisibility(
                visible = floatingActionButtonState is FloatingActionButtonState.Visible,
                enter = fadeIn() + slideInVertically() {
                    it / 2
                },
                exit = fadeOut() + slideOutVertically {
                    it / 2
                },
            ) {
                AppFloatingActionButton(
                    expanded = floatingActionButtonState is FloatingActionButtonState.Visible.Big,
                )
            }
        },
        bottomBar = {
            AnimatedVisibility(
                visible = bottomNavigationBarState is BottomNavigationBarState.Visible,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                StatefulAppBottomNavigationBar(
                    navController = navController,
                    setBottomNavigationBarState = setBottomNavigationBarState,
                    setFloatingActionButtonState = setFloatingActionButtonState,
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            AppNavigationHost(
                navController = navController,
                setBottomNavigationBarState = setBottomNavigationBarState,
                setFloatingActionButtonState = setFloatingActionButtonState,
            )
        }
    }
}
