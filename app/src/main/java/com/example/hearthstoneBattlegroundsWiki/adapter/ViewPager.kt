package com.example.hearthstoneBattlegroundsWiki.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dota2herowiki.ui.main.fragments.*
import com.example.hearthstoneBattlegroundsWiki.ui.main.fragments.FourthFragment
import com.example.hearthstoneBattlegroundsWiki.ui.main.fragments.SecondFragment

class ViewPager(activity:AppCompatActivity):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> {
                return MainFragment()
            }
            1-> {
                return SecondFragment()
            }
            2 ->{
                return ThirdFragment()
            }
            3 -> {
                return FourthFragment()
            }
            4 -> {
                return FifthFragment()
            }
            else -> {
                return SixthFragment()
            }
        }
    }
}