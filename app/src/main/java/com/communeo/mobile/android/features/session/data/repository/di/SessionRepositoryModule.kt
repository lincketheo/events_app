package com.communeo.mobile.android.features.session.data.repository.di

import android.content.Context
import com.communeo.common.data.repository.EventRepository
import com.communeo.common.data.repository.UserRepository
import com.communeo.common.data.repository.impl.FakeEventRepository
import com.communeo.common.data.repository.impl.FakeUserRepository
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

    @Provides
    fun provideUserRepository(
        @ApplicationContext context: Context,
    ): UserRepository {
        if (context.resources.getBoolean(R.bool.should_fake_user_repository)) {
            return FakeUserRepository()
        } else {
            throw NotImplementedError("Real user repository not implemented yet")
        }
    }

    @Provides
    fun provideEventsRepository(
        @ApplicationContext context: Context,
    ): EventRepository {
        if (context.resources.getBoolean(R.bool.should_fake_event_repository)) {
            return FakeEventRepository()
        } else {
            throw NotImplementedError("Real event repository not implemented yet")
        }
    }
}
