package com.example.chatgpt.domain.usecase

import com.example.chatgpt.domain.model.ChatModel
import com.example.chatgpt.repository.ChatRepository
import io.reactivex.Single
import javax.inject.Inject

class AskQuestionUseCase @Inject constructor(private val repository: ChatRepository) {

    fun execute(historyWithQuestion: List<ChatModel>): Single<ChatModel> {
        return repository.askQuestion(historyWithQuestion)
    }

}