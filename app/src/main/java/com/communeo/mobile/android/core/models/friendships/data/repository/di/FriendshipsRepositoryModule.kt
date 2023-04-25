package com.communeo.mobile.android.core.models.friendships.data.repository.di

import android.content.Context
import com.communeo.common.data.repository.FriendshipRepository
import com.communeo.common.data.repository.impl.FakeFriendshipRepository
import com.communeo.mobile.android.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FriendshipsRepositoryModule {
    @Provides
    fun provideFriendshipRepository(
        @ApplicationContext context: Context,
    ): FriendshipRepository {
        if (context.resources.getBoolean(R.bool.should_fake_friendship_repository)) {
            return FakeFriendshipRepository()
        } else {
            throw NotImplementedError("Real friendship repository not implemented yet")
        }
    }
}
