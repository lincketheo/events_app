package com.communeo.mobile.android.features.business.events.data.source.network.di

import com.communeo.mobile.android.features.business.events.data.source.network.RemoteEventDataSource
import com.communeo.mobile.android.features.business.events.data.source.network.impl.KtorRemoteEventDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RemoteEventDataSourceModule {
    @Provides
    fun provideRemoteEventDataSource(
        ktorRemoteEventDataSourceImpl: KtorRemoteEventDataSourceImpl,
    ): RemoteEventDataSource {
        return ktorRemoteEventDataSourceImpl
    }
}
