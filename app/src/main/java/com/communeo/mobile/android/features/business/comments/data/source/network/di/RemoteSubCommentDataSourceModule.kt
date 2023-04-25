package com.communeo.mobile.android.features.business.comments.data.source.network.di

import com.communeo.mobile.android.features.business.comments.data.source.network.RemoteSubCommentDataSource
import com.communeo.mobile.android.features.business.comments.data.source.network.impl.KtorRemoteSubCommentDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RemoteSubCommentDataSourceModule {
    @Provides
    fun provideRemoteSubCommentDataSource(
        ktorRemoteSubCommentDataSourceImpl: KtorRemoteSubCommentDataSourceImpl
    ): RemoteSubCommentDataSource {
        return ktorRemoteSubCommentDataSourceImpl
    }
}
