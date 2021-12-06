package com.example.taswaq.application

import android.os.Handler
import androidx.constraintlayout.motion.widget.MotionLayout

fun Handler.postDelayed(timeInMills: Long, action: () -> Unit) =
    this.postDelayed(action, timeInMills)

fun interface OnMotionCompletedListener : MotionLayout.TransitionListener {
    override fun onTransitionChange(
        motionLayout: MotionLayout?,
        startId: Int,
        endId: Int,
        progress: Float
    ) {

    }

    override fun onTransitionStarted(motionLayout: MotionLayout?, startId: Int, endId: Int) {

    }

    override fun onTransitionTrigger(
        motionLayout: MotionLayout?,
        triggerId: Int,
        positive: Boolean,
        progress: Float
    ) {

    }

}

operator fun <T> Collection<T>.get(subscript: T) =
    this.first { it == subscript }

fun <T> Collection<T>.getOrNull(subscript: T): T? =
    firstOrNull { it == subscript }
