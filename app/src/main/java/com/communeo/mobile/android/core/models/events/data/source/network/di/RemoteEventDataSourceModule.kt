package com.communeo.mobile.android.core.models.events.data.source.network.di

import com.communeo.mobile.android.core.models.events.data.source.network.RemoteEventDataSource
import com.communeo.mobile.android.core.models.events.data.source.network.impl.RemoteEventDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteEventDataSourceModule {
    @Binds
    abstract fun bindRemoteEventDataSource(
        remoteEventDataSourceImpl: RemoteEventDataSourceImpl,
    ): RemoteEventDataSource
}
