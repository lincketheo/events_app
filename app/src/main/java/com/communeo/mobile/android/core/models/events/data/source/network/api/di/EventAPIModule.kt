package com.communeo.mobile.android.core.models.events.data.source.network.api.di

import com.communeo.mobile.android.core.models.events.data.source.network.api.RetrofitEventAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class EventAPIModule {
    @Provides
    fun provideRetrofitEventAPI(): RetrofitEventAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl("localhost:8080")
            .build()
        return retrofit.create(RetrofitEventAPI::class.java)
    }
}
