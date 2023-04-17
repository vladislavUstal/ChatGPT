package com.example.chatgpt.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chatgpt.data.local.dao.ChatDao
import com.example.chatgpt.data.model.SavedChatModel


@Database(entities = [SavedChatModel::class], version = 1)
abstract class ChatDatabase : RoomDatabase() {
    abstract fun chatDao(): ChatDao

    companion object {
        const val DB_NAME = "ChatDatabase.db"
    }
}