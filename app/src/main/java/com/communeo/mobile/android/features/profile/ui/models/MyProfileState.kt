package com.communeo.mobile.android.features.profile.ui.models

import com.communeo.mobile.android.features.business.users.data.models.AuthenticatedUser
import com.communeo.mobile.android.features.business.users.data.models.PublicUser

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
