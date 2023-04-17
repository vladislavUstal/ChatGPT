package com.example.chatgpt.di.local

import android.app.Application
import androidx.room.Room
import com.example.chatgpt.data.local.dao.ChatDao
import com.example.chatgpt.data.local.db.ChatDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): ChatDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            ChatDatabase::class.java,
            ChatDatabase.DB_NAME
        )
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    open fun provideChatDao(db: ChatDatabase): ChatDao {
        return db.chatDao()
    }
}