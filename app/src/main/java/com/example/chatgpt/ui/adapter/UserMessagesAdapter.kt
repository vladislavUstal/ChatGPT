package com.example.chatgpt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chatgpt.R
import com.example.chatgpt.databinding.ItemUserMessageBinding
import com.example.chatgpt.domain.model.presentation.UserChatModel
import com.example.chatgpt.ui.adapter.delegate_adapter.BaseDelegateAdapter
import com.example.chatgpt.ui.adapter.delegate_adapter.BaseViewHolder

class UserMessagesAdapter :
    BaseDelegateAdapter<UserMessagesAdapter.UserMessage, UserChatModel>() {

    override fun onBindViewHolder(
        view: View,
        item: UserChatModel,
        viewHolder: UserMessage
    ) {
        viewHolder.binding.tvMessage.text = item.message
    }

    override fun getLayoutId(): Int {
        return R.layout.item_user_message
    }

    override fun createViewHolder(parent: ViewGroup): UserMessage {
        return UserMessage.from(parent)
    }

    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is UserChatModel
    }

    class UserMessage(
        val binding: ItemUserMessageBinding
    ) : BaseViewHolder(binding.root) {
        companion object {
            fun from(
                parent: ViewGroup
            ): UserMessage {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    ItemUserMessageBinding.inflate(layoutInflater, parent, false)
                return UserMessage(binding)
            }
        }
    }
}