package com.example.tablayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    private lateinit var appAdapt: AppAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.apply{
        tab.addTab(tab.newTab().setText("Games"))
            tab.addTab(tab.newTab().setText("Apps"))
            tab.addTab(tab.newTab().setText("Movies"))
            tab.addTab(tab.newTab().setText("Books"))
            tab.tabGravity = TabLayout.GRAVITY_FILL

            appAdapt = AppAdapter(supportFragmentManager,tab.tabCount)
            page.adapter = appAdapt

            page.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))

            tab.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab) {
                    page.currentItem = tab.position
                    Toast.makeText(this@MainActivity,tab.text.toString(), Toast.LENGTH_SHORT).show()
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {}
                override fun onTabUnselected(tab: TabLayout.Tab?) {}
            })
        }
    }


}