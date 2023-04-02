package com.example.chatgpt.ui.adapter.delegate_adapter

import android.view.View
import android.view.ViewGroup

abstract class KDelegateAdapter<T> : BaseDelegateAdapter<KDelegateAdapter.KViewHolder, T>() {
    abstract fun onBind(item: T, viewHolder: KViewHolder)

    override fun onBindViewHolder(view: View, item: T, viewHolder: KViewHolder) {
        onBind(item, viewHolder)
    }

    override fun createViewHolder(parent: ViewGroup): KViewHolder {
        return KViewHolder(parent)
    }

    class KViewHolder(override val containerView: View) : BaseViewHolder(containerView),
        LayoutContainer
}

interface LayoutContainer {
    val containerView: View?
}
