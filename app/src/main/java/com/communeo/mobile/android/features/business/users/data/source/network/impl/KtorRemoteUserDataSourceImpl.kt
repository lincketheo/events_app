package com.communeo.mobile.android.features.business.users.data.source.network.impl

import com.communeo.mobile.android.core.network.CommonKtorDataSource
import com.communeo.mobile.android.features.business.users.data.source.network.RemoteUserDataSource
import com.communeo.mobile.android.features.business.users.data.source.network.models.PublicUserResponse
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class KtorRemoteUserDataSourceImpl @Inject constructor() : RemoteUserDataSource,
    CommonKtorDataSource() {
    override suspend fun getUser(name: String): PublicUserResponse? {
        val url = "$baseUrl?name=$name"
        return client.get(url).body()
    }
}
