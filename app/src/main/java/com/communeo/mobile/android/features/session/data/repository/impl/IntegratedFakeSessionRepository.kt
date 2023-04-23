package com.communeo.mobile.android.features.session.data.repository.impl

import com.communeo.common.data.models.user.AuthenticatedUser
import com.communeo.common.data.repository.impl.FakeUserRepository
import com.communeo.mobile.android.CommuneoApplication
import com.communeo.mobile.android.R
import com.communeo.mobile.android.core.exceptions.InvalidSignInException
import com.communeo.mobile.android.features.session.data.repository.SessionRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * A session repository that integrates with all the other fakes
 *
 * It will throw an error if the user you sign in with is not inside
 * [FakeUserRepository]
 */
@Singleton
class IntegratedFakeSessionRepository
@Inject constructor() : SessionRepository {
    private val mutableUser = MutableStateFlow<AuthenticatedUser?>(null)

    override val currentlySignedInUser: Flow<AuthenticatedUser?> = mutableUser.asStateFlow()

    override suspend fun signOut() {
        mutableUser.value = null
    }

    override suspend fun signIn(name: String) {
        FakeUserRepository.publicUsers.firstOrNull { it.name == name }.let {
            it?.let { user ->
                mutableUser.value = AuthenticatedUser(user)
            } ?: run {
                mutableUser.value = null
                val msg = CommuneoApplication
                    .resources
                    .getString(R.string.there_was_a_problem_signing_in)
                throw InvalidSignInException(msg)
            }
        }
    }
}
