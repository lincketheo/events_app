package com.communeo.common.data.repository.impl

import com.communeo.common.data.models.user.FriendRequest
import com.communeo.common.data.models.user.PublicUser
import com.communeo.common.data.repository.FriendshipRepository
import kotlin.random.Random

class FakeFriendshipRepository : FriendshipRepository {
    companion object {
        private val friendRequests: MutableSet<FriendRequest> = (0..100).map {
            FriendRequest(FakeUserRepository.randomUser(), FakeUserRepository.randomUser())
        }.toMutableSet()

        val friendships: Map<PublicUser, List<PublicUser>> = run {
            val iterator = friendRequests.iterator()
            val ret = mutableMapOf<PublicUser, MutableList<PublicUser>>()
            while (iterator.hasNext()) {
                val friendRequest = iterator.next()
                when (Random.nextInt(3)) {
                    0 -> {
                        // Reject
                        iterator.remove()
                    }

                    1 -> {
                        // do nothing
                    }

                    else -> {
                        // accept
                        with(friendRequest) {
                            ret[fromPublicUser]?.add(toPublicUser) ?: run {
                                ret[fromPublicUser] = mutableListOf(toPublicUser)
                            }
                            ret[toPublicUser]?.add(fromPublicUser) ?: run {
                                ret[toPublicUser] = mutableListOf(fromPublicUser)
                            }
                        }
                    }
                }
            }
            ret
        }
    }

    override suspend fun getFriendsFor(user: PublicUser): List<PublicUser> {
        if (user !in FakeUserRepository.publicUsers) {
            throw IllegalArgumentException(
                "Tried to access " +
                        "$user who doesn't exist!"
            )
        }
        return friendships[user] ?: emptyList()
    }
}
