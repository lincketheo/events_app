package com.communeo.mobile.android.features.session.data.repository.di

import android.content.Context
import com.communeo.mobile.android.R
import com.communeo.mobile.android.features.session.data.repository.SessionRepository
import com.communeo.mobile.android.features.session.data.repository.impl.IntegratedFakeSessionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SessionRepositoryModule {
    @Provides
    fun bindSessionRepository(
        integratedFakeSessionRepository: IntegratedFakeSessionRepository,
        @ApplicationContext context: Context,
    ): SessionRepository {
        if (context.resources.getBoolean(R.bool.should_fake_session_repository)) {
            return integratedFakeSessionRepository
        } else {
            throw NotImplementedError("Real session repository not implemented yet")
        }
    }
}
