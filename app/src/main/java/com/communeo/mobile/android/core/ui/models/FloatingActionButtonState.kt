package com.communeo.mobile.android.core.ui.models

sealed interface FloatingActionButtonState {
    sealed interface Visible : FloatingActionButtonState {
        object Big : Visible
        object Small : Visible
    }
    object Invisible : FloatingActionButtonState
}
