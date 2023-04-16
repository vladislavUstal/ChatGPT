package com.example.chatgpt.data.repository_implementation

import com.example.chatgpt.data.OpenAiApi
import com.example.chatgpt.data.model.ChatGptAnswerModel
import com.example.chatgpt.data.model.QuestionToChatGptModel
import com.example.chatgpt.data.repository.ChatRepository
import io.reactivex.Single
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val api: OpenAiApi
) : ChatRepository {
    override fun askQuestion(historyWithQuestion: QuestionToChatGptModel): Single<ChatGptAnswerModel> {
        return api.askQuestion(body = historyWithQuestion)
    }
}