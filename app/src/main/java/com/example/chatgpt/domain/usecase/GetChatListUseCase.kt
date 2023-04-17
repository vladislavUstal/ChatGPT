package com.example.chatgpt.domain.usecase

import com.example.chatgpt.data.local.repository.SavedChatRepository
import com.example.chatgpt.domain.mapper.to_presentation.SavedChatToPreviewChatMapper
import com.example.chatgpt.domain.model.SavedChatPreviewModel
import io.reactivex.Single
import javax.inject.Inject

class GetChatListUseCase @Inject constructor(
    private val repository: SavedChatRepository,
    private val mapper: SavedChatToPreviewChatMapper
) {

    fun execute(): Single<List<SavedChatPreviewModel>> {
        return repository.getChatList().map { list ->
            list.map { mapper.transform(it) }
        }
    }
}