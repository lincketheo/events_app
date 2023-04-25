package com.communeo.common.data.repository

import com.communeo.common.data.models.user.PublicUser

interface UserRepository {
    suspend fun getUser(name: String): PublicUser?
}
