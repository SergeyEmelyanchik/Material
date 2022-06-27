package ru.geekbrains.material.view.animations

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        binding.recyclerView.adapter = Adapter()

    }

    inner class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_animations_recycler_item, parent, false) as View
            )
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            holder.itemView.setOnClickListener { button ->
                //explode(it)
                val epicenter = Rect()
                button.getGlobalVisibleRect(epicenter)
                val transitionExplode = Explode()
                transitionExplode.epicenterCallback = object : Transition.EpicenterCallback() {
                    override fun onGetEpicenter(transition: Transition): Rect {
                        return epicenter
                    }
                }
                transitionExplode.duration = 5000
                transitionExplode.excludeTarget(button, true)
                val transitionFade = Fade().addTarget(button)
                val transitionSet = TransitionSet()
                transitionSet.addTransition(transitionExplode)
                transitionFade.duration = 5000
                transitionSet.addTransition(transitionFade)
                TransitionManager.beginDelayedTransition(binding.recyclerView, transitionSet)
                binding.recyclerView.adapter = null
            }
        }

        override fun getItemCount(): Int {
            return 28

        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}