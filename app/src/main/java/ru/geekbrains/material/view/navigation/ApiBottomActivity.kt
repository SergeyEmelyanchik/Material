package ru.geekbrains.material.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.badge.BadgeDrawable
import ru.geekbrains.material.R
import ru.geekbrains.material.databinding.ActivityApiBottomBinding

class ApiBottomActivity : AppCompatActivity() {
    lateinit var binding: ActivityApiBottomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_bottom_navigation_earth -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, EarthFragment.newInstance()).commit()
                    true
                }
                R.id.action_bottom_navigation_system -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SystemFragment.newInstance()).commit()
                    false
                }
                R.id.action_bottom_navigation_mars -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, MarsFragment.newInstance()).commit()
                    true
                }
                else -> {
                    true
                }
            }
        }

        binding.bottomNavigation.selectedItemId = R.id.action_bottom_navigation_mars

        val badge = binding.bottomNavigation.getOrCreateBadge(R.id.action_bottom_navigation_mars)
        badge.number = 100000000
        badge.maxCharacterCount = 6
        badge.badgeGravity = BadgeDrawable.TOP_START
        binding.bottomNavigation.menu.removeItem(R.id.action_bottom_navigation_earth)
        binding.bottomNavigation.menu.removeItem(R.id.action_bottom_navigation_system)
        binding.bottomNavigation.inflateMenu(R.menu.menu_bottom_navigation_drawer)

    }
}