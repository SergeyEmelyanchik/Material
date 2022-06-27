package ru.geekbrains.material.view.animations

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

class AnimationsActivity : AppCompatActivity() {

    private val duration: Long = 1000
    var isOpen: Boolean = false
    private lateinit var binding: ActivityAnimationsBonusStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBonusStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backgroundImage.setOnClickListener {

            val constraintSet = ConstraintSet()
            //constraintSet.clone(binding.constraintContainer)

            val transition = ChangeBounds()
            transition.interpolator = AnticipateOvershootInterpolator(5f)
            transition.duration = 1000
            TransitionManager.beginDelayedTransition(binding.constraintContainer,transition )

            isOpen = !isOpen
            if(isOpen){
                constraintSet.clone(this, R.layout.activity_animations_bonus_end)
            }else{
                constraintSet.clone(this, R.layout.activity_animations_bonus_start)
            }


            constraintSet.applyTo(binding.constraintContainer)
        }
    }
}