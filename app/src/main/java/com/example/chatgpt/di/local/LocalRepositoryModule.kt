package com.example.chatgpt.di.local

import com.example.chatgpt.data.local.dao.ChatDao
import com.example.chatgpt.data.local.repository.SavedChatRepository
import com.example.chatgpt.data.local.repository_implementation.SavedChatRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class LocalRepositoryModule {

    @Provides
    fun provideChatLocalRepository(dao: ChatDao): SavedChatRepository = SavedChatRepositoryImpl(dao)

}