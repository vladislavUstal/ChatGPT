package com.example.chatgpt.data.model

import com.example.chatgpt.utils.OpenAiUtils
import java.io.Serializable

data class QuestionToChatGptModel(
    val max_tokens: Int = OpenAiUtils.maxTokens,
    val messages: List<ChatHistoryModel>,
    val model: String = OpenAiUtils.model,
    val stop: String = "None",
    val n: Int = OpenAiUtils.n,
    val temperature: Double = OpenAiUtils.temperature
) : Serializable