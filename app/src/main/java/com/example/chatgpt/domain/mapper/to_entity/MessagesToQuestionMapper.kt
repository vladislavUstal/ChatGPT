package com.example.chatgpt.domain.mapper.to_entity

import com.example.chatgpt.data.model.ChatMessageModel
import com.example.chatgpt.data.model.QuestionModel
import com.example.chatgpt.domain.mapper.IMapper
import com.example.chatgpt.domain.model.AssistantChatModel
import com.example.chatgpt.domain.model.ChatModel

class MessagesToQuestionMapper : IMapper<List<ChatModel>, QuestionModel> {
    override fun transform(data: List<ChatModel>): QuestionModel {
        return QuestionModel(
            messages = data.map { message ->
                ChatMessageModel(
                    role = if (message is AssistantChatModel) "assistant" else "user",
                    content = message.message
                )
            }
        )
    }
}