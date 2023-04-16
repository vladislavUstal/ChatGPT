package com.example.chatgpt.domain.model.presentation

abstract class ChatModel(
    open val message: String,
    open val code: Boolean
) : IAdapterModel