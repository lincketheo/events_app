package com.communeo.mobile.android.core.models.events.data.repository.di

import android.content.Context
import com.communeo.common.data.repository.EventRepository
import com.communeo.common.data.repository.impl.FakeEventRepository
import com.communeo.mobile.android.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class EventRepositoryModule {
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
