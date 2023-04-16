package com.example.chatgpt.domain.model.presentation

data class UserChatModel(
    override val message: String,
    override val code: Boolean
) : ChatModel(message, code)