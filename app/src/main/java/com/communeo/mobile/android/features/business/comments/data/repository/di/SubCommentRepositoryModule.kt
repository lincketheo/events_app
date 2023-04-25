package com.communeo.mobile.android.features.business.comments.data.repository.di

import com.communeo.mobile.android.features.business.comments.data.repository.SubCommentRepository
import com.communeo.mobile.android.features.business.comments.data.repository.impl.OnlyNetworkSubCommentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SubCommentRepositoryModule {
    @Provides
    fun provideSubCommentRepository(
        onlyNetworkSubCommentRepositoryImpl: OnlyNetworkSubCommentRepositoryImpl,
    ): SubCommentRepository {
        return onlyNetworkSubCommentRepositoryImpl
    }
}
