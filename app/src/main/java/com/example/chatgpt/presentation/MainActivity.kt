package com.example.chatgpt.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chatgpt.R
import com.example.chatgpt.presentation.ui.main_chat.ChatFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ChatFragment.newInstance())
                .commitNow()
        }
    }

}