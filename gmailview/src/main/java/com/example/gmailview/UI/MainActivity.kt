package com.example.gmailview.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmailview.Adapter.MailAdapt
import com.example.gmailview.Data.MailDetails
import com.example.gmailview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    private lateinit var mailAdapt: MailAdapt
    private val email_list = ArrayList<MailDetails>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        makeData()
    }

    private fun makeData() {
        email_list.apply {
            add(
                MailDetails(
                    "Facebook",
                    "Poked new user",
                    "You have new friends suggestion",
                    "12:00 pm",
                    false
                )
            )
            add(
                MailDetails(
                    "Instagram",
                    "chaarle24 messaged you",
                    "Read your DM and respond",
                    "2:20 pm",
                    true
                )
            )
            add(
                MailDetails(
                    "Sams Club",
                    "Savings and Coupons",
                    "New kitchen dining set discount",
                    "7:30 pm",
                    false
                )
            )
            add(
                MailDetails(
                    "Google",
                    "Is this you?",
                    "Verify this is your login information",
                    "9:43 am",
                    false
                )
            )
            add(
                MailDetails(
                    "Youtube",
                    "Resubscribe",
                    "You have new friends suggestion",
                    "4:20 am",
                    false
                )
            )
            add(
                MailDetails(
                    "Twitter",
                    "Tweet Back",
                    "You have new friends suggestion",
                    "12:02 pm",
                    false
                )
            )
            add(
                MailDetails(
                    "10%Discount",
                    "Winner Limited time",
                    "You have new friends suggestion",
                    "12:35 pm",
                    false
                )
            )
            add(
                MailDetails(
                    "Garbage Collect",
                    "Spam Related r",
                    "You have new friends suggestion",
                    "11:30 am",
                    false
                )
            )


        }
        mailAdapt = MailAdapt(email_list)
        bind.apply {

            recycleView.layoutManager = LinearLayoutManager(this@MainActivity)
            recycleView.adapter = mailAdapt
        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                email_list.removeAt(position)
                Toast.makeText(this@MainActivity, "Trash", Toast.LENGTH_SHORT).show()
            }
        }).attachToRecyclerView(bind.recycleView)

    }
}

