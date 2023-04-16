package com.example.chatgpt.domain.usecase

import com.example.chatgpt.domain.mapper.to_entity.ChatToHistoryMapper
import com.example.chatgpt.domain.mapper.to_presentation.AnswerToChatMapper
import com.example.chatgpt.domain.model.presentation.ChatModel
import com.example.chatgpt.data.repository.ChatRepository
import io.reactivex.Single
import javax.inject.Inject

class AskQuestionUseCase @Inject constructor(
    private val repository: ChatRepository,
    private val toEntityMapper: ChatToHistoryMapper,
    private val toPresentationMapper: AnswerToChatMapper
) {

    fun execute(historyWithQuestion: List<ChatModel>): Single<ChatModel> {
        return repository.askQuestion(toEntityMapper.transform(historyWithQuestion))
            .map { response ->
                toPresentationMapper.transform(response)
            }
    }

}