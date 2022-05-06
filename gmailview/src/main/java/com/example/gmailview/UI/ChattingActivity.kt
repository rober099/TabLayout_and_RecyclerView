package com.example.gmailview.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gmailview.Adapter.ChatAdapt
import com.example.gmailview.Data.Chat
import com.example.gmailview.R
import com.example.gmailview.databinding.ActivityChattingBinding

class ChattingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChattingBinding
    private lateinit var chatAdapt: ChatAdapt
    private lateinit var text_messages: ArrayList<Chat>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChattingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycler()
        addMoreMessages()
    }

    private fun setRecycler(){
        text_messages = ArrayList()
        text_messages.add(Chat(1,"Hey Alyssa, its Abhishek"))
        text_messages.add(Chat(2,"Hello Instructor"))
        text_messages.add(Chat(1,"Did you complete the application assigned last night?"))
        text_messages.add(Chat(2,"No, im a horrible student :("))
        text_messages.add(Chat(1,"Not true you and Patrick are my favorite"))
        text_messages.add(Chat(2,"I complete the homework im just playing"))
        text_messages.add(Chat(1,"Okay"))
        text_messages.add(Chat(1,"keep up good work"))
        chatAdapt = ChatAdapt(text_messages)
            binding.apply{
            chatRecycler.layoutManager = LinearLayoutManager(this@ChattingActivity)
                chatRecycler.adapter = chatAdapt
        }
    }

    private fun addMoreMessages(){
        binding.apply {
            sendIcon1.setOnClickListener{
                text_messages.add(Chat(1,writeMessage.text.toString()))
                chatAdapt.notifyItemInserted(text_messages.size)
                writeMessage.text?.clear()
            }
            sendIcon2.setOnClickListener{
                text_messages.add(Chat(2,writeMessage.text.toString()))
                chatAdapt.notifyItemInserted(text_messages.size)
                writeMessage.text?.clear()
            }
        }
    }
}