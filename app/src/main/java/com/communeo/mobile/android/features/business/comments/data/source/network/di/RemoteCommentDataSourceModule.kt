package com.communeo.mobile.android.features.business.comments.data.source.network.di

import com.communeo.mobile.android.features.business.comments.data.source.network.RemoteCommentDataSource
import com.communeo.mobile.android.features.business.comments.data.source.network.impl.KtorRemoteCommentDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RemoteCommentDataSourceModule {
    @Provides
    fun provideRemoteCommentDataSource(
        ktorRemoteCommentDataSourceImpl: KtorRemoteCommentDataSourceImpl,
    ): RemoteCommentDataSource {
        return ktorRemoteCommentDataSourceImpl
    }
}
