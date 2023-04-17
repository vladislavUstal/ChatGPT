package com.example.chatgpt.domain.mapper.to_presentation

import com.example.chatgpt.data.model.SavedChatModel
import com.example.chatgpt.domain.mapper.IMapper
import com.example.chatgpt.domain.model.SavedChatPreviewModel

class SavedChatToPreviewChatMapper : IMapper<SavedChatModel, SavedChatPreviewModel> {
    override fun transform(data: SavedChatModel): SavedChatPreviewModel {
        return SavedChatPreviewModel(
            id = data.id,
            name = ""
        )
    }

}