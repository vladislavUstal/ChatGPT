package com.example.chatgpt.data.local.dao.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: T)

    @Update
    fun update(data: T)

    @Delete
    fun delete(data: T)
}