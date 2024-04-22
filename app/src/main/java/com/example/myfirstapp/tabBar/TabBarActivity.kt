package com.example.myfirstapp.tabBar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myfirstapp.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tab_bar)
        val tabLayout: TabLayout = findViewById(R.id.tabBar)
        val viewPager2: ViewPager2 = findViewById(R.id.pagerView)

        val fragments = listOf(ChatFragment(), UpdatesFragment(), CallsFragment()) // Your fragments
        val titles = listOf("Chat", "Updates", "Calls") // Tab titles

        viewPager2.adapter = MyPagerAdapter(supportFragmentManager, lifecycle, fragments, titles)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = titles[position]
        }.attach()


    }
}