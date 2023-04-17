package com.example.chatgpt.presentation.ui.adapter.delegate_adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView


open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var listener: ItemInflateListener? = null

    fun setListener(listener: ItemInflateListener?) {
        this.listener = listener
    }

    fun bind(item: Any) {
        listener?.inflated(item, itemView)
    }

    interface ItemInflateListener {
        fun inflated(viewType: Any, view: View)
    }
}