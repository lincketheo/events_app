package com.communeo.common.data.repository

import com.communeo.common.data.models.user.PublicUser

interface FriendshipRepository {
    suspend fun getFriendsFor(user: PublicUser): List<PublicUser>
}
