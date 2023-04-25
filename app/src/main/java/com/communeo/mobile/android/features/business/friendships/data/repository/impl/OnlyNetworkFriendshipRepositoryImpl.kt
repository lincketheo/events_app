package com.communeo.mobile.android.features.business.friendships.data.repository.impl

import com.communeo.mobile.android.features.business.friendships.data.repository.FriendshipRepository
import com.communeo.mobile.android.features.business.friendships.data.source.network.RemoteFriendDataSource
import com.communeo.mobile.android.features.business.users.data.models.PublicUser
import com.communeo.mobile.android.features.business.users.data.source.network.models.toPublicUser
import javax.inject.Inject

class OnlyNetworkFriendshipRepositoryImpl @Inject constructor(
    private val remoteFriendDataSource: RemoteFriendDataSource,
) : FriendshipRepository {
    override suspend fun getMyFriends(): List<PublicUser> {
        return remoteFriendDataSource.getMyFriends().map { it.toPublicUser() }
    }

    override suspend fun getFriendsOfSomeoneElse(user: PublicUser): List<PublicUser>? {
        return remoteFriendDataSource
            .getFriendsOfSomeoneElse(user)
            ?.map { it.toPublicUser() }
    }

    override suspend fun getPendingFriendRequestsISent(): List<PublicUser> {
        return remoteFriendDataSource
            .getPendingFriendRequestsISent()
            .map { it.toPublicUser() }
    }

    override suspend fun getPendingFriendRequestsSentToMe(): List<PublicUser> {
        return remoteFriendDataSource
            .getPendingFriendRequestsSentToMe()
            .map { it.toPublicUser() }
    }

    override suspend fun getFriendshipsIRejected(): List<PublicUser> {
        return remoteFriendDataSource
            .getFriendshipsIRejected()
            .map { it.toPublicUser() }
    }
}
