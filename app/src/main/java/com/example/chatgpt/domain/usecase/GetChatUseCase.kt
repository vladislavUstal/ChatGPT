package com.example.chatgpt.domain.usecase

import com.example.chatgpt.data.local.repository.SavedChatRepository
import com.example.chatgpt.data.model.ChatMessageModel
import io.reactivex.Single
import javax.inject.Inject

class GetChatUseCase @Inject constructor(
    private val repository: SavedChatRepository
) {

    fun execute(id: Int): Single<List<ChatMessageModel>> {
        return Single.just(listOf())//repository.getChat(id)
    }

}