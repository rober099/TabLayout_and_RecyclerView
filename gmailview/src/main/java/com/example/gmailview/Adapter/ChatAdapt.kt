package com.example.gmailview.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmailview.Data.Chat
import com.example.gmailview.databinding.ReceiverViewBinding
import com.example.gmailview.databinding.SenderViewBinding

class ChatAdapt(private val texts: List<Chat>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var bindingSender: SenderViewBinding
    private lateinit var bindingReceiver: ReceiverViewBinding

    override fun getItemCount() = texts.size

    //when you have more than one view type in recycler view of same list
    override fun getItemViewType(position: Int): Int{
        return texts[position].viewType
    }

    //call only once to create adapter for recyler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        return if(viewType == SENDER_VIEW) {
            bindingSender = SenderViewBinding.inflate(layoutInflater, parent, false)
            SenderHolder(bindingSender.root)
        }else{
            bindingReceiver = ReceiverViewBinding.inflate(layoutInflater,parent,false)
            ReceiverHolder(bindingReceiver.root)
      }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (texts[position].viewType == SENDER_VIEW){
            (holder as SenderHolder).bind(position)
        }else{
            (holder as ReceiverHolder).bind(position)
        }
    }

    inner class SenderHolder(view: View): RecyclerView.ViewHolder(view){
        private val txtSender: TextView = bindingSender.senderText
        fun bind(position: Int){
            txtSender.text = texts[position].text
        }
    }

    inner class ReceiverHolder(view: View): RecyclerView.ViewHolder(view){
    private val txtReceiver: TextView = bindingReceiver.senderText
        fun bind(position: Int){
            txtReceiver.text = texts[position].text
        }
    }


    companion object{
        const val SENDER_VIEW = 1
    }

}