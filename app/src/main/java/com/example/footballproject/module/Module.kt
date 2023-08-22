package com.example.footballproject.module

import com.example.data.FootballRepositoryMock
import com.example.domain.repository.FootballRepository
import com.example.domain.usecase.FootballUseCase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@dagger.Module
class Module {

    @Provides
    @Singleton
    fun provideRepository():FootballRepository{
        return FootballRepositoryMock()
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: FootballRepository):FootballUseCase{
        return FootballUseCase(repository)
    }

}