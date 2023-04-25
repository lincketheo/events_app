package com.communeo.mobile.android.features.business.users.data.source.network.di

import com.communeo.mobile.android.features.business.users.data.source.network.RemoteUserDataSource
import com.communeo.mobile.android.features.business.users.data.source.network.impl.KtorRemoteUserDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RemoteUserDataSourceModule {
    @Provides
    fun provideRemoteUserDataSource(
        ktorRemoteUserDataSourceImpl: KtorRemoteUserDataSourceImpl,
    ): RemoteUserDataSource {
        return ktorRemoteUserDataSourceImpl
    }
}
