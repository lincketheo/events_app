package com.communeo.mobile.android.core.models.users.data.repository.di

import android.content.Context
import com.communeo.common.data.repository.UserRepository
import com.communeo.common.data.repository.impl.FakeUserRepository
import com.communeo.mobile.android.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UserRepositoryModule {
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
}
