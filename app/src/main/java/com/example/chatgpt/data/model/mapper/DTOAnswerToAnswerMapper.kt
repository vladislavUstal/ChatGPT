package com.example.chatgpt.data.model.mapper

import com.example.chatgpt.data.model.OpenAiResponseModel
import com.example.chatgpt.domain.model.AssistantChatModel
import com.example.chatgpt.domain.model.ChatModel


class DTOAnswerToAnswerMapper : IMapper<OpenAiResponseModel, ChatModel> {
    override fun transform(data: OpenAiResponseModel): ChatModel {
        return AssistantChatModel(
            message = data.choices[0].message.content,
            false
        )
    }

}