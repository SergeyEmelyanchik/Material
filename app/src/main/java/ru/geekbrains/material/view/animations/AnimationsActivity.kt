package ru.geekbrains.material.view.animations

import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import ru.geekbrains.material.R
import ru.geekbrains.material.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

    private val duration: Long = 1000
    var isOpen: Boolean = false
    private lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.header.isSelected = true
        binding.header.isSelected = false*/
        binding.scrollView.setOnScrollChangeListener { _, _, _, _, _ ->
            binding.header.isSelected = binding.scrollView.canScrollVertically(-1)
        }
    }
}