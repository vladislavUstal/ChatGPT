package com.example.chatgpt

import android.app.Application
import com.example.chatgpt.di.AppComponent
import com.example.chatgpt.di.DaggerAppComponent

class MyApp : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MyApp
        fun get(): MyApp {
            return instance
        }
    }

    private fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerAppComponent.factory().create(applicationContext)
    }

}