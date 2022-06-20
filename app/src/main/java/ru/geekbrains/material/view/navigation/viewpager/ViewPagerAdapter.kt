package ru.geekbrains.material.view.navigation.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import ru.geekbrains.material.view.navigation.EarthFragment
import ru.geekbrains.material.view.navigation.MarsFragment
import ru.geekbrains.material.view.navigation.SystemFragment

class ViewPagerAdapter(private val fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    private val fragments = arrayOf(EarthFragment(), SystemFragment(), MarsFragment())//TODO HW зафиксировать фрагменты на своих местах

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0-> "Earth"
            1-> "System"
            else -> "Mars"
        }
    }

} 