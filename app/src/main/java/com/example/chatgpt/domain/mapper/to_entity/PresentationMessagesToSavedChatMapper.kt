package com.example.chatgpt.domain.mapper.to_entity

import com.example.chatgpt.data.model.SavedChatModel
import com.example.chatgpt.domain.mapper.IMapper
import com.example.chatgpt.domain.model.ChatModel

class PresentationMessagesToSavedChatMapper : IMapper<List<ChatModel>, List<SavedChatModel>> {
    override fun transform(data: List<ChatModel>): List<SavedChatModel> {
        return data.map { message ->
            SavedChatModel(
                id = 0
            )
        }
    }
}