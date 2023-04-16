package com.example.chatgpt.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chatgpt.MyApp
import com.example.chatgpt.domain.model.presentation.ChatModel
import com.example.chatgpt.domain.model.presentation.UserChatModel
import com.example.chatgpt.domain.usecase.AskQuestionUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChatViewModel(app: Application) : AndroidViewModel(app) {

    init {
        MyApp.instance.appComponent.inject(this)
    }

    @Inject
    lateinit var askQuestionUseCase: AskQuestionUseCase

    var question: ObservableField<String> = ObservableField()

    private val _messages: MutableLiveData<List<ChatModel>> = MutableLiveData()
    val messages: LiveData<List<ChatModel>> = _messages

    private val disposable: CompositeDisposable = CompositeDisposable()

    private fun setMessages(message: ChatModel) {
        val newList = messages.value?.toMutableList() ?: mutableListOf()
        newList.add(message)
        _messages.apply {
            value = newList
        }
    }

    fun sendQuestion() {
        val question = this.question.get()
        this.question.set("")
        if (!question.isNullOrEmpty()) {
            setMessages(
                UserChatModel(
                    message = question,
                    code = false
                )
            )
            disposable.add(
                askQuestionUseCase.execute(_messages.value ?: listOf())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                        setMessages(
                            response
                        )
                    }, {

                    })
            )
        }
    }

    fun getMessages() = _messages.value ?: listOf()

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

}