package com.example.dota2herowiki.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dota2herowiki.R
import com.example.dota2herowiki.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.viewPager2.adapter =
            com.example.hearthstoneBattlegroundsWiki.adapter.ViewPager(this)

        TabLayoutMediator(binding.tabs, binding.viewPager2) { tab, position ->
            binding.viewPager2.currentItem = 0
            when (position) {
                0 -> tab.text = getString(R.string.one)
                1 -> tab.text = getString(R.string.two)
                2 -> tab.text = getString(R.string.three)
                3 -> tab.text = getString(R.string.four)
                4 -> tab.text = getString(R.string.five)
                5 -> tab.text = getString(R.string.six)

            }
        }.attach()
    }
}