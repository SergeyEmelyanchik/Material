package ru.geekbrains.material.view.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.geekbrains.material.R
import ru.geekbrains.material.databinding.ActivityLayoutBinding
import ru.geekbrains.material.view.layout.constraint.ConstraintFragment
import ru.geekbrains.material.view.layout.coordinator.CoordinatorFragment
import ru.geekbrains.material.view.layout.motion.MotionFragment

class LayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_bottom_navigation_constraint -> {
                    navigationTo(ConstraintFragment())
                    true
                }
                R.id.action_bottom_navigation_coordinator -> {
                    navigationTo(CoordinatorFragment())
                    true
                }
                R.id.action_bottom_navigation_motion -> {
                    navigationTo(MotionFragment())
                    true
                }
                else -> true
            }
        }
        binding.bottomNavigationView.selectedItemId = R.id.action_bottom_navigation_coordinator
    }

    private fun navigationTo(f: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, f).commit()
    }


}