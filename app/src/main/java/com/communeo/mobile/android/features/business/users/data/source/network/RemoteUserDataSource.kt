package com.communeo.mobile.android.features.business.users.data.source.network

import com.communeo.mobile.android.features.business.users.data.source.network.models.PublicUserResponse

interface RemoteUserDataSource {
    suspend fun getUser(name: String): PublicUserResponse?
}
