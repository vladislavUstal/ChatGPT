package com.example.chatgpt.utils

import com.example.chatgpt.BuildConfig

object OpenAiUtils {

    const val apiKey = BuildConfig.API_KEY
    const val model = "gpt-3.5-turbo"
    const val temperature = 0.5
    const val maxTokens = 1024
    const val n = 1

}