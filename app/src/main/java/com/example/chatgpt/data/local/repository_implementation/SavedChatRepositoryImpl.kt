package com.example.chatgpt.data.local.repository_implementation

import com.example.chatgpt.data.local.dao.ChatDao
import com.example.chatgpt.data.local.repository.SavedChatRepository
import com.example.chatgpt.data.model.SavedChatModel
import io.reactivex.Single
import javax.inject.Inject

class SavedChatRepositoryImpl @Inject constructor(private val chatDao: ChatDao) :
    SavedChatRepository {
    override fun saveChat(data: SavedChatModel) {
        chatDao.insert(data)
    }

    override fun getChat(id: Int): Single<List<SavedChatModel>> {
        return chatDao.getChatById(id)
    }

    override fun getChatList(): Single<List<SavedChatModel>> {
        return chatDao.getChatList()
    }
}