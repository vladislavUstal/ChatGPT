package com.example.chatgpt.data.repository_implementation

import com.example.chatgpt.data.OpenAiApi
import com.example.chatgpt.data.model.mapper.ChatHistoryToDTOMapper
import com.example.chatgpt.data.model.mapper.DTOAnswerToAnswerMapper
import com.example.chatgpt.domain.model.ChatModel
import com.example.chatgpt.repository.ChatRepository
import io.reactivex.Single
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val api: OpenAiApi,
    private val toDTOMapper: ChatHistoryToDTOMapper,
    private val fromDTOMapper: DTOAnswerToAnswerMapper
) : ChatRepository {
    override fun askQuestion(historyWithQuestion: List<ChatModel>): Single<ChatModel> {
        return api.askQuestion(body = toDTOMapper.transform(historyWithQuestion)).map { response ->
            fromDTOMapper.transform(response)
        }
    }
}