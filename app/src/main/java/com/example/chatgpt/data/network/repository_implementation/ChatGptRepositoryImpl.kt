package com.example.chatgpt.data.network.repository_implementation

import com.example.chatgpt.data.model.ChatGptAnswerModel
import com.example.chatgpt.data.model.QuestionModel
import com.example.chatgpt.data.network.OpenAiApi
import com.example.chatgpt.data.network.repository.ChatGptRepository
import io.reactivex.Single
import javax.inject.Inject

class ChatGptRepositoryImpl @Inject constructor(
    private val api: OpenAiApi
) : ChatGptRepository {
    override fun askQuestion(historyWithQuestion: QuestionModel): Single<ChatGptAnswerModel> {
        return api.askQuestion(body = historyWithQuestion)
    }
}