package com.example.chatgpt.domain.usecase

import com.example.chatgpt.data.local.repository.SavedChatRepository
import com.example.chatgpt.data.model.SavedChatModel
import com.example.chatgpt.domain.mapper.to_entity.PresentationMessagesToSavedChatMapper
import com.example.chatgpt.domain.model.ChatModel
import javax.inject.Inject

class SaveChatUseCase @Inject constructor(
    private val repository: SavedChatRepository,
    private val toEntityMapper: PresentationMessagesToSavedChatMapper
) {

    fun execute(data: List<ChatModel>) { // : Completable
        return repository.saveChat(
            SavedChatModel(id = 0)
        )
    }

}