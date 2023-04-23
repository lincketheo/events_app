package com.communeo.mobile.android.features.session.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun StatefulSignInPage(
    onSignInAttempt: (String) -> Unit,
    errorMessage: String?,
    consumerErrorMessage: () -> Unit,
) {
    /**
     * The current name that is entered inside the
     * input text box for sign in
     */
    var nameInputState by remember { mutableStateOf("") }

    /**
     * The state of the sign in screen snackbar
     */
    val snackBarHostState = remember { SnackbarHostState() }

    /**
     * If error message is not null, launch a snackbar and tell
     * the view model that you received the error message
     * ("consume" the error message)
     */
    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            snackBarHostState.showSnackbar(it)
        }
        consumerErrorMessage()
    }

    StatelessSignInPage(
        snackBarHostState = snackBarHostState,
        nameInputValue = nameInputState,
        onNameInputChange = {
            nameInputState = it
        },
        onSignInButtonClicked = {
            onSignInAttempt(nameInputState)
        },
    )
}

@Composable
fun StatelessSignInPage(
    snackBarHostState: SnackbarHostState,
    nameInputValue: String,
    onNameInputChange: (newNameInputValue: String) -> Unit,
    onSignInButtonClicked: () -> Unit
) {
    Scaffold(
        snackbarHost = {
            SnackbarHost(snackBarHostState)
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextField(
                value = nameInputValue,
                onValueChange = { newNameInputValue -> onNameInputChange(newNameInputValue) },
                label = { Text("name") },
                maxLines = 10,
                textStyle = TextStyle(
                    color = Color.Blue, fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(20.dp)
            )
            Button(onClick = { onSignInButtonClicked() }) {
                Text("Sign In")
            }
        }
    }
}
