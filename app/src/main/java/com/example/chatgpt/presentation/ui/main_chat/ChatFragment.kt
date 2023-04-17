package com.example.chatgpt.presentation.ui.main_chat

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.example.chatgpt.R
import com.example.chatgpt.databinding.FragmentChatBinding
import com.example.chatgpt.presentation.ui.adapter.AssistantMessagesAdapter
import com.example.chatgpt.presentation.ui.adapter.UserMessagesAdapter
import com.example.chatgpt.presentation.ui.adapter.delegate_adapter.CompositeDelegateAdapter
import com.example.chatgpt.presentation.viewmodel.ChatViewModel


class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val viewModel: ChatViewModel by viewModels()
    private val adapter = CompositeDelegateAdapter.Builder()
        .add(UserMessagesAdapter())
        .add(AssistantMessagesAdapter())
        //.add(SavedChatListAdapter())
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

        viewModel.onError = ::showErrorToast

        initToolbar()

//        viewModel.savedChats.observe(viewLifecycleOwner) { chats ->
//            adapter.swapData(chats)
//        }

        //viewModel.initSavedChat()

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

    private fun showErrorToast() {
        Toast.makeText(requireContext(), getString(R.string.error_text), Toast.LENGTH_SHORT).show()
    }

    private fun initToolbar() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.save_chat -> {
                        //viewModel.saveChat()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    companion object {
        fun newInstance() = ChatFragment()
    }

}