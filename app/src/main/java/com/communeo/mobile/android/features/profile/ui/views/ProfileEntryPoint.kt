package com.communeo.mobile.android.features.profile.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.communeo.common.data.models.user.PublicUser
import com.communeo.mobile.android.features.profile.ui.viewmodels.MyProfileViewModel
import com.communeo.mobile.android.features.profile.ui.views.me.MyProfileEntryPoint
import com.communeo.mobile.android.features.profile.ui.views.notme.NotMyProfileEntryPoint

@Composable
fun ProfileEntryPoint(
    myProfileViewModel: MyProfileViewModel,
) {
    val uiState by myProfileViewModel.uiState.collectAsState()
    uiState?.let {
        MyProfileEntryPoint(
            myProfileState = it,
            signOutAssuredly = myProfileViewModel::signOutAssuredly,
            loadFriends = myProfileViewModel::loadFriends,
        )
    }
}

@Composable
fun ProfileEntryPoint(
    user: PublicUser,
) {
    NotMyProfileEntryPoint(
        user,
    )
}
