package com.example.chatgpt.di

import com.example.chatgpt.data.OpenAiApi
import com.example.chatgpt.data.model.mapper.ChatHistoryToDTOMapper
import com.example.chatgpt.data.model.mapper.DTOAnswerToAnswerMapper
import com.example.chatgpt.data.repository_implementation.ChatRepositoryImpl
import com.example.chatgpt.data.repository.ChatRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideChatRepository(
        api: OpenAiApi,
        chatHistoryToDTOMapper: ChatHistoryToDTOMapper,
        dTOAnswerToAnswerMapper: DTOAnswerToAnswerMapper
    ): ChatRepository = ChatRepositoryImpl(api, chatHistoryToDTOMapper, dTOAnswerToAnswerMapper)

}