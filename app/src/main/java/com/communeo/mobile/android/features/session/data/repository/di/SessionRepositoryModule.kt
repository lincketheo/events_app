package com.communeo.mobile.android.features.session.data.repository.di

import com.communeo.mobile.android.features.session.data.repository.SessionRepository
import com.communeo.mobile.android.features.session.data.repository.impl.SessionRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SessionRepositoryModule {
    @Provides
    fun providesSessionRepository(
        sessionRepositoryImpl: SessionRepositoryImpl,
    ): SessionRepository {
        return sessionRepositoryImpl
    }
}
