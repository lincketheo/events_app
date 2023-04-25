package com.communeo.mobile.android.features.business.friendships.data.repository.di

import com.communeo.mobile.android.features.business.friendships.data.repository.FriendshipRepository
import com.communeo.mobile.android.features.business.friendships.data.repository.impl.OnlyNetworkFriendshipRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FriendshipsRepositoryModule {
    @Provides
    fun provideFriendshipRepository(
        onlyNetworkFriendshipRepositoryImpl: OnlyNetworkFriendshipRepositoryImpl,
    ): FriendshipRepository {
        return onlyNetworkFriendshipRepositoryImpl
    }
}
