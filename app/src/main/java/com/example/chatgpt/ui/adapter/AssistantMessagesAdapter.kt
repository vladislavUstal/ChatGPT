package com.example.chatgpt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chatgpt.R
import com.example.chatgpt.databinding.ItemAssistantMessageBinding
import com.example.chatgpt.domain.model.AssistantChatModel
import com.example.chatgpt.ui.adapter.delegate_adapter.BaseDelegateAdapter
import com.example.chatgpt.ui.adapter.delegate_adapter.BaseViewHolder

class AssistantMessagesAdapter :
    BaseDelegateAdapter<AssistantMessagesAdapter.AssistantMessage, AssistantChatModel>() {

    override fun onBindViewHolder(
        view: View,
        item: AssistantChatModel,
        viewHolder: AssistantMessage
    ) {
        viewHolder.binding.tvMessage.text = item.message
    }

    override fun getLayoutId(): Int {
        return R.layout.item_user_message
    }

    override fun createViewHolder(parent: ViewGroup): AssistantMessage {
        return AssistantMessage.from(parent)
    }

    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is AssistantChatModel
    }

    class AssistantMessage(
        val binding: ItemAssistantMessageBinding
    ) : BaseViewHolder(binding.root) {
        companion object {
            fun from(
                parent: ViewGroup
            ): AssistantMessage {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    ItemAssistantMessageBinding.inflate(layoutInflater, parent, false)
                return AssistantMessage(binding)
            }
        }
    }
}