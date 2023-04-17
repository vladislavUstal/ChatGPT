package com.example.chatgpt.data.model

import java.io.Serializable

data class ChatMessageModel(
    val role: String = "",
    val content: String = "",
) : Serializable