package com.example.chatgpt.di.network

import com.example.chatgpt.data.network.OpenAiApi
import com.example.chatgpt.data.network.repository.ChatGptRepository
import com.example.chatgpt.data.network.repository_implementation.ChatGptRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class NetworkRepositoryModule {

    @Provides
    fun provideChatRepository(api: OpenAiApi): ChatGptRepository = ChatGptRepositoryImpl(api)

}