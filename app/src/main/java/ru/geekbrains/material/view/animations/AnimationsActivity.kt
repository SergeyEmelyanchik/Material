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

    var isOpen: Boolean = false
    private lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            isOpen = !isOpen
            val transition = ChangeBounds()
            val path = ArcMotion()
            transition.setPathMotion(path)
            transition.duration = 3000
            TransitionManager.beginDelayedTransition(binding.root, transition)
            val params = (binding.button.layoutParams as FrameLayout.LayoutParams)
            params.gravity = if (isOpen) {
                Gravity.BOTTOM or Gravity.END
            } else {
                Gravity.TOP or Gravity.START
            }
            binding.button.layoutParams = params
        }
    }
}