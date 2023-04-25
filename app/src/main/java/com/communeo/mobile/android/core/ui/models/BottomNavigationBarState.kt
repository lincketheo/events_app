package com.communeo.mobile.android.core.ui.models

sealed interface BottomNavigationBarState {
    object Visible : BottomNavigationBarState
    object Invisible : BottomNavigationBarState
}
