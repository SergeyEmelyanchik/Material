package ru.geekbrains.material.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ru.geekbrains.material.R
import ru.geekbrains.material.databinding.ActivityApiBinding
import ru.geekbrains.material.view.navigation.viewpager.ViewPager2Adapter

class ApiActivity : AppCompatActivity() {
    lateinit var binding: ActivityApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyBlueTheme)
        binding = ActivityApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPager2Adapter(this)

        TabLayoutMediator(binding.tabLayout,binding.viewPager,object :TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                //TDDO HW настраиваем tab
                tab.text = when(position){
                    0-> "Earth"
                    1-> "System"
                    else -> "Mars"
                }
            }
        } ).attach()
    }
}
