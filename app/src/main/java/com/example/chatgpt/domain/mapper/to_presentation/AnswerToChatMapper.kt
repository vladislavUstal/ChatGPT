package com.example.chatgpt.domain.mapper.to_presentation

import com.example.chatgpt.data.model.ChatGptAnswerModel
import com.example.chatgpt.domain.mapper.IMapper
import com.example.chatgpt.domain.model.presentation.AssistantChatModel
import com.example.chatgpt.domain.model.presentation.ChatModel

class AnswerToChatMapper : IMapper<ChatGptAnswerModel, ChatModel> {
    override fun transform(data: ChatGptAnswerModel): ChatModel {
        return AssistantChatModel(
            message = data.choices[0].message.content,
            false
        )
    }

}