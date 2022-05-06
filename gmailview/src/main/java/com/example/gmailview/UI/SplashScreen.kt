package com.example.gmailview.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gmailview.R
import com.example.gmailview.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.emailBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.chatBtn.setOnClickListener{
            startActivity(Intent(this, ChattingActivity::class.java))
        }
    }
}