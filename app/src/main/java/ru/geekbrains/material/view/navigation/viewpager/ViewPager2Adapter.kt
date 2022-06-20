package ru.geekbrains.material.view.navigation.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.geekbrains.material.view.navigation.EarthFragment
import ru.geekbrains.material.view.navigation.MarsFragment
import ru.geekbrains.material.view.navigation.SystemFragment

class ViewPager2Adapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = fragments.size

    private val fragments = arrayOf(EarthFragment(),  SystemFragment(),MarsFragment())
    override fun createFragment(position: Int): Fragment{
        return fragments[position]
    }
}