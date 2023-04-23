package com.communeo.mobile.android.features.session.data.repository.impl

import com.communeo.common.data.models.user.AuthenticatedUser
import com.communeo.common.data.models.user.PublicUser
import com.communeo.mobile.android.features.session.data.repository.SessionRepository
import java.net.URL
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FakeSessionRepository : SessionRepository {
    /**
     * This can be altered by users of the fake class
     */
    val mutableUser = MutableStateFlow<AuthenticatedUser?>(null)
    override val currentlySignedInUser: Flow<AuthenticatedUser?> = mutableUser.asStateFlow()
    override suspend fun signOut() {
        mutableUser.value = null
    }
    override suspend fun signIn(name: String) {
        mutableUser.value = AuthenticatedUser(
            PublicUser(
                name = name,
                profilePictureUrl = URL("https://picsum.photos/200"),
            )
        )
    }
}
