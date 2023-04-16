package com.example.chatgpt.di

import android.content.Context
import com.example.chatgpt.viewmodel.ChatViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        NetworkModule::class,
        UseCaseModule::class,
        MapperModule::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): AppComponent

    }

    fun inject(vm: ChatViewModel)

}