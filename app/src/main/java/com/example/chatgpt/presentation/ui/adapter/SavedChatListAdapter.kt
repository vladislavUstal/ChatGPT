package com.example.chatgpt.presentation.ui.adapter

//class ChatListAdapter :
//    BaseDelegateAdapter<ChatListAdapter.ChatListViewHolder, ChatListItem>() {
//
//    override fun onBindViewHolder(
//        view: View,
//        item: ChatListItem,
//        viewHolder: ChatListViewHolder
//    ) {
//        viewHolder.binding.tvMessage.text = item.name
//    }
//
//    override fun getLayoutId(): Int {
//        return R.layout.item_assistant_message
//    }
//
//    override fun createViewHolder(parent: ViewGroup): ChatListViewHolder {
//        return ChatListViewHolder.from(parent)
//    }
//
//    override fun isForViewType(items: List<Any>, position: Int): Boolean {
//        return items[position] is ChatListItem
//    }
//
//    class ChatListViewHolder(
//        val binding: ItemAssistantMessageBinding
//    ) : BaseViewHolder(binding.root) {
//        companion object {
//            fun from(
//                parent: ViewGroup
//            ): ChatListViewHolder {
//                val layoutInflater = LayoutInflater.from(parent.context)
//                val binding =
//                    ItemAssistantMessageBinding.inflate(layoutInflater, parent, false)
//                return ChatListViewHolder(binding)
//            }
//        }
//    }
//}