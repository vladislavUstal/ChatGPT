package com.example.chatgpt.domain.mapper

interface IMapper<SRC, DST> {
    fun transform(data: SRC): DST
}