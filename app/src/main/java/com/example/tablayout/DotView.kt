package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tablayout.databinding.ActivityDotViewBinding
import com.google.android.material.tabs.TabLayout

class DotView : AppCompatActivity() {
    private lateinit var binding: ActivityDotViewBinding
    private lateinit var appAdapter: AppAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDotViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            tabLay.addTab(tabLay.newTab().setIcon(R.drawable.ic_baseline_games_24))
            tabLay.addTab(tabLay.newTab().setIcon(R.drawable.ic_baseline_app_shortcut_24))
            tabLay.addTab(tabLay.newTab().setIcon(R.drawable.ic_baseline_local_movies_24))
            tabLay.addTab(
                tabLay.newTab().setIcon(R.drawable.ic_baseline_menu_book_24)
            )

            appAdapter = AppAdapter(supportFragmentManager, tabLay.tabCount)
            pages.adapter = appAdapter
            tabLay.setupWithViewPager(pages)
            // make view pager synchronous with tab layout
            pages.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLay))
        }
    }
}