package com.communeo.mobile.android.core.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.communeo.mobile.android.features.session.ui.models.AuthenticatedState
import com.communeo.mobile.android.features.session.ui.viewmodels.SessionViewModel
import com.communeo.mobile.android.features.session.ui.views.AuthenticatedEntryPoint
import com.communeo.mobile.android.features.session.ui.views.UnauthenticatedEntryPoint

@Composable
fun AppEntryPoint(
    sessionViewModel: SessionViewModel,
) {
    val sessionUiState by sessionViewModel.sessionState.collectAsState()
    sessionUiState.authenticationState.let {
        when (it) {
            is AuthenticatedState.Unknown -> {
                Text("Splash Page Temporary Holder")
            }
            is AuthenticatedState.Unauthenticated -> {
                UnauthenticatedEntryPoint(
                    onSignInAttempted = sessionViewModel::attemptSignIn,
                    errorMessage = sessionUiState.sessionErrorMessage,
                    consumeErrorMessage = sessionViewModel::consumeSessionError,
                )
            }
            is AuthenticatedState.Authenticated -> {
                AuthenticatedEntryPoint()
            }
        }
    }
}
