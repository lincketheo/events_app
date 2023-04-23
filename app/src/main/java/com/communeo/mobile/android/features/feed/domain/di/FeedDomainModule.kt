package com.communeo.mobile.android.features.feed.domain.di

import com.communeo.common.data.repository.EventRepository
import com.communeo.common.domain.GetEventFeedUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FeedDomainModule {
    @Provides
    fun provideGetEventFeedUseCase(
        eventRepository: EventRepository,
    ): GetEventFeedUseCase {
        return GetEventFeedUseCase(eventRepository)
    }
}
