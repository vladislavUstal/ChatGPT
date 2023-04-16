package com.example.chatgpt.data.repository

import com.example.chatgpt.data.model.ChatGptAnswerModel
import com.example.chatgpt.data.model.QuestionToChatGptModel
import io.reactivex.Single

interface ChatRepository {

    fun askQuestion(historyWithQuestion: QuestionToChatGptModel): Single<ChatGptAnswerModel>

}