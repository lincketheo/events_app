package com.communeo.mobile.android.features.business.friendships.data.source.network.di

import com.communeo.mobile.android.features.business.friendships.data.source.network.RemoteFriendDataSource
import com.communeo.mobile.android.features.business.friendships.data.source.network.impl.KtorRemoteFriendDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RemoteFriendDataSourceModule {
    @Provides
    fun provideRemoteFriendDataSource(
        ktorRemoteFriendDataSourceImpl: KtorRemoteFriendDataSourceImpl,
    ): RemoteFriendDataSource {
        return ktorRemoteFriendDataSourceImpl
    }
}
