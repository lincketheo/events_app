package com.communeo.mobile.android.features.session.ui.views

import androidx.compose.runtime.Composable

@Composable
fun UnauthenticatedEntryPoint(
    onSignInAttempted: (String) -> Unit,
    errorMessage: String?,
    consumeErrorMessage: () -> Unit,
) {
    StatefulSignInPage(
        onSignInAttempt = onSignInAttempted,
        errorMessage = errorMessage,
        consumerErrorMessage = consumeErrorMessage
    )
}
