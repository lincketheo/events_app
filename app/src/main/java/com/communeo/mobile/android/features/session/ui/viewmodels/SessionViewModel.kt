package com.communeo.mobile.android.features.session.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.communeo.mobile.android.core.exceptions.InvalidSignInException
import com.communeo.mobile.android.core.logging.CommuneoLoggerFactory
import com.communeo.mobile.android.features.session.data.repository.SessionRepository
import com.communeo.mobile.android.features.session.ui.models.AuthenticatedState
import com.communeo.mobile.android.features.session.ui.models.SessionUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@HiltViewModel
class SessionViewModel @Inject constructor(
    private val sessionRepository: SessionRepository,
) : ViewModel() {

    private val logger = CommuneoLoggerFactory.getLogger(this)

    private val _sessionState: MutableStateFlow<SessionUiState> =
        MutableStateFlow(SessionUiState.initial)
    val sessionState = _sessionState.asStateFlow()

    fun attemptSignIn(name: String) {
        viewModelScope.launch {
            try {
                sessionRepository.signIn(name)
            } catch (e: InvalidSignInException) {
                logger.info("Sign In Error: ${e.localizedMessage}")
                _sessionState.update {
                    it.copy(sessionErrorMessage = e.localizedMessage)
                }
            }
        }
    }

    fun onSignOut() {
        viewModelScope.launch {
            sessionRepository.signOut()
        }
    }

    /**
     * Let the view model know that you've acknowledged
     * the error message
     */
    fun consumeSessionError() {
        viewModelScope.launch {
            _sessionState.update { it.copy(sessionErrorMessage = null) }
        }
    }

    init {
        viewModelScope.launch {

            /**
             * Collect each state change of the session repository
             * which can either be null or an authenticated user
             *
             * Update the ui state accordingly
             */
            sessionRepository
                .currentlySignedInUser
                .onEach { user ->
                    logger.debug("Session just transitioned")
                    user?.let { authenticatedUser ->
                        _sessionState.update { sessionUiState ->
                            sessionUiState.copy(
                                authenticationState = AuthenticatedState.Authenticated(
                                    authenticatedUser
                                )
                            )
                        }
                    } ?: run {
                        _sessionState.update { sessionUiState ->
                            sessionUiState.copy(
                                authenticationState = AuthenticatedState.Unauthenticated,
                            )
                        }
                    }
                }.collect()
        }
    }
}
