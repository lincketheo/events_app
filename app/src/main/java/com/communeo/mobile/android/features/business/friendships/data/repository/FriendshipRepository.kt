package com.communeo.mobile.android.features.business.friendships.data.repository

import com.communeo.mobile.android.features.business.users.data.models.PublicUser

interface FriendshipRepository {
    /**
     * Gets **your** ([user]) friends without permission restrictions
     */
    suspend fun getMyFriends(): List<PublicUser>

    /**
     * Gets someone else's ([user]) friends while considering if that user has their
     * permissions set up to share their friend list to the [requester] (you). If this
     * is null, [user] has privacy settings in place that restrict [requester] from
     * seeing their user
     */
    suspend fun getFriendsOfSomeoneElse(user: PublicUser): List<PublicUser>?

    /**
     * Returns a list of friends that [user] has sent, but the
     * requested friend has not accepted nor rejected yet
     */
    suspend fun getPendingFriendRequestsISent(): List<PublicUser>

    /**
     * Returns a list of friends that were sent to [user] that [user]
     * has neither accepted nor rejected
     */
    suspend fun getPendingFriendRequestsSentToMe(): List<PublicUser>

    /**
     * This probably deletes after some time - Might even remove it. Who knows
     */
    suspend fun getFriendshipsIRejected(): List<PublicUser>
}
