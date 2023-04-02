package com.example.chatgpt.repository

import com.example.chatgpt.domain.model.ChatModel
import io.reactivex.Single

interface ChatRepository {

    fun askQuestion(historyWithQuestion: List<ChatModel>): Single<ChatModel>

}