package com.example.chatgpt.domain.model.presentation

class AssistantChatModel(
    override val message: String,
    override val code: Boolean
) : ChatModel(message, code)