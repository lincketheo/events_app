package com.communeo.mobile.android.features.profile.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.communeo.common.data.repository.FriendshipRepository
import com.communeo.mobile.android.core.coroutines.di.ApplicationScope
import com.communeo.mobile.android.core.logging.CommuneoLoggerFactory
import com.communeo.mobile.android.features.profile.ui.models.MyProfileState
import com.communeo.mobile.android.features.session.data.repository.SessionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@HiltViewModel
class MyProfileViewModel @Inject constructor(
    private val sessionRepository: SessionRepository,
    private val friendshipRepository: FriendshipRepository,
    @ApplicationScope private val applicationScope: CoroutineScope,
) : ViewModel() {
    private val logger = CommuneoLoggerFactory.getLogger(this)
    private var _uiState = MutableStateFlow<MyProfileState?>(null)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            sessionRepository
                .currentlySignedInUser
                .cancellable()
                .onEach { user ->
                    user?.let {
                        _uiState.update { state ->
                            state?.copy(user = user)
                                ?: MyProfileState.initial(user)
                        }
                    } ?: _uiState.update { null }
                }
                .collect()
        }
    }

    fun signOutAssuredly() {
        applicationScope.launch {
            sessionRepository.signOut()
        }
    }

    fun loadFriends() {
        viewModelScope.launch {

            /**
             * Load friends and store them in uiState
             */
            _uiState.update { state ->
                state?.let {
                    state.copy(
                        loadedFriends = friendshipRepository
                            .getMyFriends(state.user)
                    )
                } ?: throw IllegalArgumentException(
                    "Tried to load friends for user who's not signed in"
                )
            }

            /**
             * Load other friends
             */
            _uiState.update { state ->
                state?.let {
                    state.copy(
                        loadedPendingFriendIRequested = friendshipRepository
                            .getPendingFriendRequestsISent(state.user),
                        loadedPendingFriendsRequestedToMe = friendshipRepository
                            .getPendingFriendRequestsSentToMe(state.user),
                        loadedRejectedFriends = friendshipRepository
                            .getFriendshipsIRejected(state.user)
                    )
                } ?: throw IllegalArgumentException(
                    "Tried to load friends for user who's not signed in"
                )
            }
        }
    }
}
