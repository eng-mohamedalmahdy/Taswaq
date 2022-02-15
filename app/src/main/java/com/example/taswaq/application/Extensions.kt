package com.example.taswaq.application

import android.graphics.Color
import com.example.taswaq.application.ColorUtil.*
import android.os.Handler
import android.util.Log
import android.widget.EditText
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

    override fun onTransitionStarted(motionLayout: MotionLayout?, startId: Int, endId: Int) {}

    override fun onTransitionTrigger(
        motionLayout: MotionLayout?,
        triggerId: Int,
        positive: Boolean,
        progress: Float
    ) {
    }

}

operator fun <T> Collection<T>.get(subscript: T) =
    first { it == subscript }

fun <T> Collection<T>.getOrNull(subscript: T): T? =
    firstOrNull { it == subscript }


fun EditText.contentAsString(): String = this.text.toString()

operator fun String.times(times: Int): String {
    var res = ""
    repeat(times) { res += this }
    return res
}

fun String.padZero(): String {
    val times = this.length % 2
    return "${"0" * times}$this"
}

fun Int.invertColor(blackWhiteInvertingOnlyEnabled: Boolean = false): Int {
    val r = red(this)
    val g = green(this)
    val b = blue(this)
    return if (blackWhiteInvertingOnlyEnabled) {
        if ((r * 0.299 + g * 0.587 + b * 0.114) > 186)
            Color.BLACK else Color.WHITE
    } else {
        val invertedRed = (255 - r).toString(16).padZero()
        val invertedGreen = (255 - g).toString(16).padZero()
        val invertedBlue = (255 - b).toString(16).padZero()
        val invertedColor = "#$invertedRed$invertedGreen$invertedBlue"
        Log.d("TAG", "invertColor: $invertedColor")
        Color.parseColor(invertedColor)
    }
}
