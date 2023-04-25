package com.communeo.common.data.models.user

import com.communeo.common.data.repository.impl.FakeUserRepository

data class FriendRequest(
    val fromPublicUser: PublicUser,
    val toPublicUser: PublicUser,
) {
    companion object {
        fun random(
            fromPublicUser: PublicUser? = null,
            toPublicUser: PublicUser? = null,
        ): FriendRequest {
            assert(fromPublicUser != toPublicUser) { "Random friendship cannot be to oneself!" }
            return FriendRequest(
                fromPublicUser = fromPublicUser ?: FakeUserRepository.randomUser(),
                toPublicUser = toPublicUser ?: FakeUserRepository.randomUser(),
            )
        }
    }
}
