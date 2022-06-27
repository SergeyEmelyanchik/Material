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
import ru.geekbrains.material.databinding.ActivityAnimationsNewBinding

class AnimationsActivity : AppCompatActivity() {

    private val duration: Long = 1000
    var isOpen: Boolean = false
    private lateinit var binding: ActivityAnimationsNewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val constraintSetStart = ConstraintSet()
        val constraintSetEnd = ConstraintSet()
        constraintSetStart.clone(this, R.layout.include_fab_animations_start)
        constraintSetEnd.clone(this, R.layout.include_fab_animations_end)
        binding.anim.fabCenter.setOnClickListener {


            isOpen = !isOpen
            if (isOpen) {
                constraintSetStart.applyTo(binding.anim.container)
                //    constraintSet.connect(R.id.title,ConstraintSet.RIGHT,R.id.backgroundImage,ConstraintSet.RIGHT) // через код
                // constraintSet.clone(this, R.layout.activity_animations_bonus_end)  // через макет
            } else {
                constraintSetEnd.applyTo(binding.anim.container)
                //    constraintSet.connect(R.id.title,ConstraintSet.RIGHT,R.id.backgroundImage,ConstraintSet.LEFT)     // через код
                // constraintSet.clone(this, R.layout.activity_animations_bonus_start) // через макет
            }
        }
    }
}