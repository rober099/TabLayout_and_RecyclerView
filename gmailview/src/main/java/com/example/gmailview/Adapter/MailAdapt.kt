package com.example.gmailview.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmailview.Data.MailDetails
import com.example.gmailview.R
import com.example.gmailview.databinding.MailViewBinding

class MailAdapt(private val mailDetail: List<MailDetails>) :
        RecyclerView.Adapter<MailAdapt.MailViewHolder>(){

     lateinit var binding: MailViewBinding

        override fun getItemCount() = mailDetail.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailViewHolder {
            val items = LayoutInflater.from(parent.context)
                binding = MailViewBinding.inflate(items,parent,false)
            return MailViewHolder(binding.root)
        }

        override fun onBindViewHolder(holder: MailViewHolder, position: Int){
            holder.apply{
                mailName.text = mailDetail[position].sender
                mailTitle.text = mailDetail[position].title
                message.text = mailDetail[position].body
                time.text = mailDetail[position].time

                if (mailDetail[position].isFavor){
                    favImg.setImageResource(R.drawable.ic_baseline_favorite_24)
                }else{
                    favImg.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }

        }


    }

    inner class MailViewHolder(view: View): RecyclerView.ViewHolder(view){

        val mailName: TextView = binding.emailName
        val mailTitle: TextView = binding.emailTitle
        val message: TextView = binding.message
        val time: TextView = binding.fakeTime
        val favImg: ImageView = binding.favorPic

    }
}