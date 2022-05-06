package com.example.recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    private lateinit var countryAdapt: CountryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        countryAdapt = CountryAdapter(
            listOf("Afghanistan",
            "Bahamas",
            "Barbados",
            "Denmark",
            "Canada",
            "Costa Rica",
            "Ecuador",
            "Cuba",
            "Egypt",
            "France",
            "Greece",
            "India",
            "Morocco",
            "Nigeria",
            "Venezuela",
                "Turkey",
                "Togo",
            "Thailand",
            "South Korea",
            "Rwanda",
            "Russia",
            "Philippines",
            "Panama"
            )
        )
        bind.countryView.layoutManager = LinearLayoutManager(this)
        bind.countryView.adapter = countryAdapt
    }
}