package com.example.chatgpt.data.model.mapper

interface IMapper<SRC, DST> {
    fun transform(data: SRC): DST
}