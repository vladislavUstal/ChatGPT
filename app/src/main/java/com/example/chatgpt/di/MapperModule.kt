package com.example.chatgpt.di

import com.example.chatgpt.domain.mapper.to_entity.MessagesToQuestionMapper
import com.example.chatgpt.domain.mapper.to_entity.PresentationMessagesToSavedChatMapper
import com.example.chatgpt.domain.mapper.to_presentation.AnswerToChatMapper
import com.example.chatgpt.domain.mapper.to_presentation.SavedChatToPreviewChatMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun provideChatHistoryMapper(): MessagesToQuestionMapper = MessagesToQuestionMapper()

    @Provides
    fun provideDTOChatHistoryMapper(): AnswerToChatMapper = AnswerToChatMapper()

    @Provides
    fun provideChatEntityToChatMapper(): SavedChatToPreviewChatMapper =
        SavedChatToPreviewChatMapper()

    @Provides
    fun provideChatToEntity(): PresentationMessagesToSavedChatMapper =
        PresentationMessagesToSavedChatMapper()

}