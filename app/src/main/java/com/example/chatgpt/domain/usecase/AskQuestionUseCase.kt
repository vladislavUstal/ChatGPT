package com.example.chatgpt.domain.usecase

import com.example.chatgpt.data.network.repository.ChatGptRepository
import com.example.chatgpt.domain.mapper.to_entity.MessagesToQuestionMapper
import com.example.chatgpt.domain.mapper.to_presentation.AnswerToChatMapper
import com.example.chatgpt.domain.model.ChatModel
import io.reactivex.Single
import javax.inject.Inject

class AskQuestionUseCase @Inject constructor(
    private val repository: ChatGptRepository,
    private val toEntityMapper: MessagesToQuestionMapper,
    private val toPresentationMapper: AnswerToChatMapper
) {

    fun execute(chat: List<ChatModel>): Single<ChatModel> {
        return repository.askQuestion(toEntityMapper.transform(chat))
            .map { response ->
                toPresentationMapper.transform(response)
            }
    }

}