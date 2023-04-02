package com.example.chatgpt.data

import com.example.chatgpt.data.model.OpenAiResponseModel
import com.example.chatgpt.data.model.RequestToChatModel
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
        @Body body: RequestToChatModel
    ): Single<OpenAiResponseModel>


}