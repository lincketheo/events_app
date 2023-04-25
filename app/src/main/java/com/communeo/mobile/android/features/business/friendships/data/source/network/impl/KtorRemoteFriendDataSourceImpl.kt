package com.communeo.mobile.android.features.business.friendships.data.source.network.impl

import com.communeo.mobile.android.core.network.CommonKtorDataSource
import com.communeo.mobile.android.features.business.friendships.data.source.network.RemoteFriendDataSource
import com.communeo.mobile.android.features.business.users.data.models.PublicUser
import com.communeo.mobile.android.features.business.users.data.source.network.models.PublicUserResponse
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class KtorRemoteFriendDataSourceImpl @Inject constructor() : RemoteFriendDataSource,
    CommonKtorDataSource() {
    override suspend fun getMyFriends(): List<PublicUserResponse> {
        val url = "$baseUrl/friends"
        return client.get(url).body()
    }

    override suspend fun getFriendsOfSomeoneElse(user: PublicUser): List<PublicUserResponse>? {
        val url = "$baseUrl/${user.id}/friends"
        return client.get(url).body()
    }

    override suspend fun getPendingFriendRequestsISent(): List<PublicUserResponse> {
        val url = "$baseUrl/friendRequests/fromMe"
        return client.get(url).body()
    }

    override suspend fun getPendingFriendRequestsSentToMe(): List<PublicUserResponse> {
        val url = "$baseUrl/friendRequests/toMe"
        return client.get(url).body()
    }

    override suspend fun getFriendshipsIRejected(): List<PublicUserResponse> {
        val url = "$baseUrl/friendRequests/rejectedByMe"
        return client.get(url).body()
    }
}
