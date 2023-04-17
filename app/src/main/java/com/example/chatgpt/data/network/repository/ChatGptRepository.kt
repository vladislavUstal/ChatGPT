package com.example.chatgpt.data.network.repository

import com.example.chatgpt.data.model.ChatGptAnswerModel
import com.example.chatgpt.data.model.QuestionModel
import io.reactivex.Single

interface ChatGptRepository {

    fun askQuestion(historyWithQuestion: QuestionModel): Single<ChatGptAnswerModel>

}