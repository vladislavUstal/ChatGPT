package com.example.chatgpt.di

import com.example.chatgpt.data.model.mapper.ChatHistoryToDTOMapper
import com.example.chatgpt.data.model.mapper.DTOAnswerToAnswerMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun provideChatHistoryMapper(): ChatHistoryToDTOMapper = ChatHistoryToDTOMapper()

    @Provides
    fun provideDTOChatHistoryMapper(): DTOAnswerToAnswerMapper = DTOAnswerToAnswerMapper()

}