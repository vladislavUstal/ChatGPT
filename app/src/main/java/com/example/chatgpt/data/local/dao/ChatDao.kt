package com.example.chatgpt.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.chatgpt.data.local.dao.base.BaseDao
import com.example.chatgpt.data.model.SavedChatModel
import io.reactivex.Single

@Dao
abstract class ChatDao : BaseDao<SavedChatModel> {

    @Query("SELECT * from saved_chat WHERE id=:id")
    abstract fun getChatById(id: Int): Single<List<SavedChatModel>>

    @Query("SELECT * from saved_chat")
    abstract fun getChatList(): Single<List<SavedChatModel>>

}