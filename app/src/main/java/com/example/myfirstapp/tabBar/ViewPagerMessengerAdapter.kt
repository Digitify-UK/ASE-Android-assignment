package com.example.myfirstapp.tabBar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerMessengerAdapter(tabBarBottomNavAndDrawerActivity:TabBarActivity ) : FragmentStateAdapter(tabBarBottomNavAndDrawerActivity) {
   private val tabCounts:Int =3
    override fun getItemCount(): Int {
        return tabCounts;
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->{
                return ChatFragment()
            }
            1->{
                return CallsFragment()
            }
            2->{
                return UpdatesFragment()
            }
        }
        return ChatFragment()

    }

}
class MyPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, private val fragments: List<Fragment>, private val titles: List<String>) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}
