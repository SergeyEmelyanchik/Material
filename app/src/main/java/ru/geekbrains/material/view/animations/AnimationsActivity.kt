package ru.geekbrains.material.view.animations

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.*
import ru.geekbrains.material.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

    var isOpen: Boolean = false
    private lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val transitionFade = Fade()
            val transitionSlide = Slide(Gravity.END)
            transitionFade.duration = 3000
            val transitionChangeBounds = ChangeBounds()
            transitionChangeBounds.duration = 5000
            val transitionSet = TransitionSet()
            // transitionSet.addTransition(transitionFade)
            transitionSet.addTransition(transitionChangeBounds)
            transitionSet.addTransition(transitionSlide)
            TransitionManager.beginDelayedTransition(binding.transitionsContainer, transitionSet)
            isOpen = !isOpen
            binding.text.visibility = if (isOpen) {
                View.VISIBLE
            } else {
                View.GONE
            }

        }

    }
}