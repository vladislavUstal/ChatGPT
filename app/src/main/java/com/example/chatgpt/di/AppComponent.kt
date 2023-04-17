package com.example.chatgpt.di

import android.app.Application
import com.example.chatgpt.di.local.DatabaseModule
import com.example.chatgpt.di.local.LocalRepositoryModule
import com.example.chatgpt.di.network.NetworkModule
import com.example.chatgpt.di.network.NetworkRepositoryModule
import com.example.chatgpt.presentation.viewmodel.ChatViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkRepositoryModule::class,
        NetworkModule::class,
        UseCaseModule::class,
        MapperModule::class,
        DatabaseModule::class,
        LocalRepositoryModule::class

    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }

    fun inject(vm: ChatViewModel)

}