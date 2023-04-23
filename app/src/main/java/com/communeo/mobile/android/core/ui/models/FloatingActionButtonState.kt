package com.example.events.ui.models.common

sealed interface FloatingActionButtonState {
    sealed interface Visible : FloatingActionButtonState {
        object Big : Visible
        object Small : Visible
    }
    object Invisible : FloatingActionButtonState
}
