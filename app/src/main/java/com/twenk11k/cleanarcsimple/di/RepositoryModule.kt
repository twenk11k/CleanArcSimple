package com.twenk11k.cleanarcsimple.di

import com.twenk11k.cleanarcsimple.data.repository.ListingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideListingRepository(
        listingService: ListingService
    ) = ListingRepository(listingService)

}