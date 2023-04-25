package com.communeo.mobile.android.features.business.users.data.repository.di

import com.communeo.mobile.android.features.business.users.data.repository.UserRepository
import com.communeo.mobile.android.features.business.users.data.repository.impl.OnlyNetworkUserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UserRepositoryModule {
    @Provides
    fun provideUserRepository(
        onlyNetworkUserRepositoryImpl: OnlyNetworkUserRepositoryImpl,
    ): UserRepository {
        return onlyNetworkUserRepositoryImpl
    }
}
