package com.communeo.mobile.android.features.business.users.data.repository.impl

import com.communeo.mobile.android.features.business.users.data.models.PublicUser
import com.communeo.mobile.android.features.business.users.data.repository.UserRepository
import com.communeo.mobile.android.features.business.users.data.source.network.RemoteUserDataSource
import com.communeo.mobile.android.features.business.users.data.source.network.models.toPublicUser
import javax.inject.Inject

class OnlyNetworkUserRepositoryImpl @Inject constructor(
    private val remoteUserDataSource: RemoteUserDataSource,
) : UserRepository {
    override suspend fun getUser(name: String): PublicUser? {
        return remoteUserDataSource.getUser(name)?.toPublicUser()
    }
}
