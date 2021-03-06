package ru.geekbrains.material.view.animations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import ru.geekbrains.material.R
import ru.geekbrains.material.databinding.ActivityAnimationsBinding
import ru.geekbrains.material.databinding.ActivityAnimationsBonusStartBinding
import ru.geekbrains.material.databinding.ActivityAnimationsNewBinding
import ru.geekbrains.material.databinding.ActivityAnimationsRotateFabBinding

class AnimationsActivity : AppCompatActivity() {

    val duration = 1000L
    lateinit var binding: ActivityAnimationsRotateFabBinding
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsRotateFabBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fab.setOnClickListener {
            flag = !flag
            if (flag) {
                ObjectAnimator.ofFloat(binding.plusImageview, View.ROTATION, 0f, 405f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer, View.TRANSLATION_Y, -50f, -260f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer, View.TRANSLATION_Y, -20f, -130f)
                    .setDuration(duration).start()

                binding.optionOneContainer.animate()
                    .alpha(1f)
                    .setDuration(duration / 2)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            binding.optionOneContainer.isClickable = true
                        }
                    })
                binding.optionTwoContainer.animate()
                    .alpha(1f)
                    .setDuration(duration / 2)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            binding.optionTwoContainer.isClickable = true
                        }
                    })

                binding.transparentBackground.animate()
                    .alpha(0.5f)
                    .setDuration(duration)
            } else {
                ObjectAnimator.ofFloat(binding.plusImageview, View.ROTATION, 405f, 0f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer, View.TRANSLATION_Y, -260f, -50f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer, View.TRANSLATION_Y, -130f, -20f)
                    .setDuration(duration).start()
                binding.optionOneContainer.animate()
                    .alpha(0f)
                    .setDuration(duration / 2)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            binding.optionOneContainer.isClickable = false
                        }
                    })
                binding.optionTwoContainer.animate()
                    .alpha(0f)
                    .setDuration(duration / 2)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            binding.optionTwoContainer.isClickable = false
                        }
                    })
                binding.transparentBackground.animate()
                    .alpha(0f)
                    .setDuration(duration)
            }
        }
    }
}