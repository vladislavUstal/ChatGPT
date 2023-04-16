package com.example.chatgpt.domain.mapper.to_entity

import com.example.chatgpt.data.model.ChatHistoryModel
import com.example.chatgpt.data.model.QuestionToChatGptModel
import com.example.chatgpt.domain.mapper.IMapper
import com.example.chatgpt.domain.model.presentation.AssistantChatModel
import com.example.chatgpt.domain.model.presentation.ChatModel

class ChatToHistoryMapper : IMapper<List<ChatModel>, QuestionToChatGptModel> {
    override fun transform(data: List<ChatModel>): QuestionToChatGptModel {
        return QuestionToChatGptModel(
            messages = data.map { message ->
                ChatHistoryModel(
                    role = if (message is AssistantChatModel) "assistant" else "user",
                    content = message.message
                )
            }
        )
    }
}