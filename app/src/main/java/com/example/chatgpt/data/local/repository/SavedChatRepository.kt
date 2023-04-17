package com.example.chatgpt.data.local.repository

import com.example.chatgpt.data.model.SavedChatModel
import io.reactivex.Single

interface SavedChatRepository {

    fun saveChat(data: SavedChatModel)

    fun getChat(id: Int): Single<List<SavedChatModel>>

    fun getChatList(): Single<List<SavedChatModel>>

}