package ru.geekbrains.material.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.material.R
import ru.geekbrains.material.databinding.ActivityApiBinding
import ru.geekbrains.material.view.navigation.viewpager.ViewPagerAdapter

class ApiActivity : AppCompatActivity() {
    lateinit var binding: ActivityApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_earth)
        binding.tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_system)
        binding.tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_mars)
    }
}

