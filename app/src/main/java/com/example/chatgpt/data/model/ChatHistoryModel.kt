package com.example.chatgpt.data.model

import java.io.Serializable

data class ChatHistoryModel(val role: String, val content: String) : Serializable