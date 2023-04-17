package com.example.chatgpt.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_chat")
data class SavedChatModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int
)
