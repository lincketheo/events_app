package com.communeo.mobile.android.features.business.comments.data.repository.di

import com.communeo.mobile.android.features.business.comments.data.repository.CommentRepository
import com.communeo.mobile.android.features.business.comments.data.repository.impl.OnlyNetworkCommentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CommentRepositoryModule {
    @Provides
    fun provideCommentRepository(
        onlyNetworkCommentRepositoryImpl: OnlyNetworkCommentRepositoryImpl,
    ): CommentRepository {
        return onlyNetworkCommentRepositoryImpl
    }
}
