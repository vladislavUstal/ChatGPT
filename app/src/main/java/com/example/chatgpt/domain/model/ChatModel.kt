package com.example.chatgpt.domain.model

abstract class ChatModel(
    open val message: String,
    open val code: Boolean
) : IAdapterModel