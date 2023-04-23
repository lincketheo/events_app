package com.communeo.mobile.android.features.profile.ui.models

import com.communeo.common.data.models.user.AuthenticatedUser
import com.communeo.common.data.models.user.PublicUser

data class MyProfileState(
    val user: AuthenticatedUser,
    val loadedFriends: List<PublicUser>,
    val loadedPendingFriendIRequested: List<PublicUser>,
    val loadedPendingFriendsRequestedToMe: List<PublicUser>,
    val loadedRejectedFriends: List<PublicUser>,
) {
    companion object {
        fun initial(user: AuthenticatedUser) = MyProfileState(
            user,
            emptyList(),
            emptyList(),
            emptyList(),
            emptyList(),
        )
    }
}
