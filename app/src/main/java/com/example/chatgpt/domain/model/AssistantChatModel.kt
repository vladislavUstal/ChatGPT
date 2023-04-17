package com.example.chatgpt.domain.model

class AssistantChatModel(
    override val message: String,
    override val code: Boolean
) : ChatModel(message, code)