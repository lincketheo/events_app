package com.communeo.mobile.android.features.business.users.data.repository

import com.communeo.mobile.android.features.business.users.data.models.PublicUser

interface UserRepository {
    suspend fun getUser(name: String): PublicUser?
}
