package com.communeo.mobile.android.features.session.data.repository

import com.communeo.common.data.models.user.AuthenticatedUser
import kotlinx.coroutines.flow.Flow

interface SessionRepository {
    val currentlySignedInUser: Flow<AuthenticatedUser?>
    suspend fun signOut()
    suspend fun signIn(name: String)
}
