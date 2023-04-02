package com.example.chatgpt.di

import com.example.chatgpt.domain.usecase.AskQuestionUseCase
import com.example.chatgpt.repository.ChatRepository
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

    @Provides
    fun provideQuestionUseCase(repo: ChatRepository): AskQuestionUseCase = AskQuestionUseCase(repo)

}