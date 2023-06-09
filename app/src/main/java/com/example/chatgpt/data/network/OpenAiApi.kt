package com.example.chatgpt.data.network

import com.example.chatgpt.data.model.ChatGptAnswerModel
import com.example.chatgpt.data.model.QuestionModel
import com.example.chatgpt.utils.OpenAiUtils
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OpenAiApi {
    @POST("chat/completions")
    fun askQuestion(
        @Header("Content-Type") contentType: String = "application/json",
        @Header("Authorization") auth: String = OpenAiUtils.apiKey,
        @Body body: QuestionModel
    ): Single<ChatGptAnswerModel>


}