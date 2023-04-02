package com.example.chatgpt.data.model.mapper

import com.example.chatgpt.data.model.ChatHistoryModel
import com.example.chatgpt.data.model.RequestToChatModel
import com.example.chatgpt.domain.model.AssistantChatModel
import com.example.chatgpt.domain.model.ChatModel

class ChatHistoryToDTOMapper : IMapper<List<ChatModel>, RequestToChatModel> {
    override fun transform(data: List<ChatModel>): RequestToChatModel {
        return RequestToChatModel(
            messages = data.map { message ->
                ChatHistoryModel(
                    role = if (message is AssistantChatModel) "assistant" else "user",
                    content = message.message
                )
            }
        )
    }
}