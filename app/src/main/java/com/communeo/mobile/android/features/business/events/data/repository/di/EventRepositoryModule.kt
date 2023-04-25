package com.communeo.mobile.android.features.business.events.data.repository.di

import com.communeo.mobile.android.features.business.events.data.repository.EventRepository
import com.communeo.mobile.android.features.business.events.data.repository.impl.OnlyNetworkEventRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class EventRepositoryModule {
    @Provides
    fun provideEventsRepository(
        onlyNetworkEventRepositoryImpl: OnlyNetworkEventRepositoryImpl,
    ): EventRepository {
        return onlyNetworkEventRepositoryImpl
    }
}
