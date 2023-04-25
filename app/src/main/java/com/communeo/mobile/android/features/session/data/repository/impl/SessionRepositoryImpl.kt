package com.communeo.mobile.android.features.session.data.repository.impl

import com.communeo.mobile.android.features.business.users.data.models.AuthenticatedUser
import com.communeo.mobile.android.features.business.users.data.models.PublicUser
import com.communeo.mobile.android.features.session.data.repository.SessionRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SessionRepositoryImpl @Inject constructor() : SessionRepository {
    private val _user = MutableStateFlow<AuthenticatedUser?>(null)

    override val currentlySignedInUser = _user.asStateFlow()

    override suspend fun signOut() {
        _user.value = null
    }

    override suspend fun signIn(name: String) {
        _user.value = AuthenticatedUser(PublicUser.random(name = name))
    }
}
