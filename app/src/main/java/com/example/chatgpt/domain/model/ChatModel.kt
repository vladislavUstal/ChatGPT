package com.example.chatgpt.domain.model

import com.example.chatgpt.ui.adapter.delegate_adapter.IAdapterModel

abstract class ChatModel(
    open val message: String,
    open val code: Boolean
) : IAdapterModel