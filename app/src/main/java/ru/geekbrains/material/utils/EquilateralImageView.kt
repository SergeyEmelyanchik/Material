package ru.geekbrains.material.utils

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import ru.geekbrains.material.view.layout.coordinator.behavior.ButtonBehavior

class EquilateralImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr), CoordinatorLayout.AttachedBehavior {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
    override fun getBehavior(): CoordinatorLayout.Behavior<*> {
        return ButtonBehavior(context)
    }
}