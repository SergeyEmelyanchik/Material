package ru.geekbrains.material.view.animations

import android.graphics.Rect
import android.os.Bundle
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

        binding.imageView.setOnClickListener {
            isOpen = !isOpen
            val transitionCB = ChangeBounds()
            val transitionImage = ChangeImageTransform()
            transitionCB.duration = 3000
            transitionImage.duration = 3000
            val transitionSet = TransitionSet()
            transitionSet.addTransition(transitionCB)
            transitionSet.addTransition(transitionImage)
            TransitionManager.beginDelayedTransition(binding.root, transitionSet)
            binding.imageView.scaleType = if (isOpen) {
                ImageView.ScaleType.CENTER_CROP
            } else {
                ImageView.ScaleType.CENTER_INSIDE
            }
            // (binding.imageView.layoutParams as  FrameLayout.LayoutParams)
            val params = (binding.imageView.layoutParams as FrameLayout.LayoutParams)
            params.height = if (isOpen) {
                FrameLayout.LayoutParams.MATCH_PARENT
            } else {
                FrameLayout.LayoutParams.WRAP_CONTENT
            }
            binding.imageView.layoutParams = params
        }
    }
}