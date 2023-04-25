package com.communeo.mobile.android.features.business.friendships.data.source.network

import com.communeo.mobile.android.features.business.users.data.models.PublicUser
import com.communeo.mobile.android.features.business.users.data.source.network.models.PublicUserResponse

interface RemoteFriendDataSource {
    suspend fun getMyFriends(): List<PublicUserResponse>
    suspend fun getFriendsOfSomeoneElse(user: PublicUser): List<PublicUserResponse>?
    suspend fun getPendingFriendRequestsISent(): List<PublicUserResponse>
    suspend fun getPendingFriendRequestsSentToMe(): List<PublicUserResponse>
    suspend fun getFriendshipsIRejected(): List<PublicUserResponse>
}
