package com.example.chatgpt.presentation.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chatgpt.MyApp
import com.example.chatgpt.domain.model.AssistantChatModel
import com.example.chatgpt.domain.model.ChatModel
import com.example.chatgpt.domain.model.SavedChatPreviewModel
import com.example.chatgpt.domain.model.UserChatModel
import com.example.chatgpt.domain.usecase.AskQuestionUseCase
import com.example.chatgpt.domain.usecase.GetChatListUseCase
import com.example.chatgpt.domain.usecase.SaveChatUseCase
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

    @Inject
    lateinit var getChatListUseCase: GetChatListUseCase

    @Inject
    lateinit var saveChatUseCase: SaveChatUseCase

    var question: ObservableField<String> = ObservableField()

    private val _messages: MutableLiveData<List<ChatModel>> = MutableLiveData()
    val messages: LiveData<List<ChatModel>> = _messages

    private val _savedChats: MutableLiveData<List<SavedChatPreviewModel>> = MutableLiveData()
    val savedChats: LiveData<List<SavedChatPreviewModel>> = _savedChats

    private val disposable: CompositeDisposable = CompositeDisposable()

    var onError: () -> Unit = {}

    private fun setMessages(message: ChatModel) {
        val newList = messages.value?.toMutableList() ?: mutableListOf()
        newList.add(message)
        _messages.apply {
            value = newList
        }
    }

    private fun setSavedChats(data: List<SavedChatPreviewModel>) {
        _savedChats.apply {
            value = data
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
                askQuestionUseCase.execute(
                    _messages.value?.filter {
                        it is UserChatModel || it is AssistantChatModel
                    } ?: listOf()
                )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                        setMessages(
                            response
                        )
                    }, {
                        onError.invoke()
                    })
            )
        }
    }

    fun initSavedChat() {
        disposable.add(
            getChatListUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    setSavedChats(
                        response
                    )
                }, {
                    onError.invoke()
                })
        )
    }

    fun saveChat() {
        saveChatUseCase.execute(
            _messages.value ?: listOf() // return completable
        )
    }

    fun getMessages() = _messages.value ?: listOf()

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

}