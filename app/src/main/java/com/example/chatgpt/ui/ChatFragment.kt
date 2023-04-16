package com.example.chatgpt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.chatgpt.databinding.FragmentChatBinding
import com.example.chatgpt.ui.adapter.AssistantMessagesAdapter
import com.example.chatgpt.ui.adapter.UserMessagesAdapter
import com.example.chatgpt.ui.adapter.delegate_adapter.CompositeDelegateAdapter
import com.example.chatgpt.viewmodel.ChatViewModel

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val viewModel: ChatViewModel by viewModels()
    private val adapter = CompositeDelegateAdapter.Builder()
        .add(UserMessagesAdapter())
        .add(AssistantMessagesAdapter())
        .build()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.messages.observe(viewLifecycleOwner) { messages ->
            adapter.swapData(viewModel.getMessages())
            binding.rv.scrollToPosition(messages.size - 1)
        }

        binding.btnAsk.setOnClickListener {
            viewModel.sendQuestion()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentChatBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.rv.adapter = adapter

        return binding.root
    }

    companion object {
        fun newInstance() = ChatFragment()
    }

}