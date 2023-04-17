package com.example.chatgpt.di

import com.example.chatgpt.data.local.repository.SavedChatRepository
import com.example.chatgpt.data.network.repository.ChatGptRepository
import com.example.chatgpt.domain.mapper.to_entity.MessagesToQuestionMapper
import com.example.chatgpt.domain.mapper.to_entity.PresentationMessagesToSavedChatMapper
import com.example.chatgpt.domain.mapper.to_presentation.AnswerToChatMapper
import com.example.chatgpt.domain.mapper.to_presentation.SavedChatToPreviewChatMapper
import com.example.chatgpt.domain.usecase.AskQuestionUseCase
import com.example.chatgpt.domain.usecase.GetChatListUseCase
import com.example.chatgpt.domain.usecase.GetChatUseCase
import com.example.chatgpt.domain.usecase.SaveChatUseCase
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

    @Provides
    fun provideQuestionUseCase(
        repo: ChatGptRepository,
        messagesToQuestionMapper: MessagesToQuestionMapper,
        answerToChatMapper: AnswerToChatMapper
    ): AskQuestionUseCase = AskQuestionUseCase(repo, messagesToQuestionMapper, answerToChatMapper)

    @Provides
    fun provideGetChatUseCase(
        repo: SavedChatRepository,
    ): GetChatUseCase = GetChatUseCase(repo)

    @Provides
    fun provideSaveChatUseCase(
        repo: SavedChatRepository,
        presentationMessagesToSavedChatMapper: PresentationMessagesToSavedChatMapper
    ): SaveChatUseCase = SaveChatUseCase(repo, presentationMessagesToSavedChatMapper)

    @Provides
    fun provideGetChatListUseCase(
        repo: SavedChatRepository,
        mapper: SavedChatToPreviewChatMapper
    ): GetChatListUseCase = GetChatListUseCase(repo, mapper)

}