package com.example.events.ui.models.common

sealed interface BottomNavigationBarState {
    object Visible : BottomNavigationBarState
    object Invisible : BottomNavigationBarState
}
