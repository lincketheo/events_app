package com.communeo.mobile.android.features.session.ui.models

import com.communeo.mobile.android.features.business.users.data.models.AuthenticatedUser

data class SessionUiState(
    val sessionErrorMessage: String?,
    val authenticationState: AuthenticatedState,
) {
    companion object {
        val initial = SessionUiState(null, AuthenticatedState.Unknown)
    }
}

sealed interface AuthenticatedState {
    object Unknown : AuthenticatedState

    data class Authenticated(
        val user: AuthenticatedUser,
    ) : AuthenticatedState

    object Unauthenticated : AuthenticatedState
}
