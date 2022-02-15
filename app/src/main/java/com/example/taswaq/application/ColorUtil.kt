package com.example.taswaq.application

import androidx.annotation.ColorInt
import com.example.taswaq.application.ColorUtil

/**
 * Utility class for colors. This class is necessary, since many useful methods for dealing with
 * colors (eg. [android.graphics.Color.rgb] were only introduced in API level
 * 26 ([android.os.Build.VERSION_CODES.O]).
 */
object ColorUtil {
    /**
     * Encode ARGB values as a color int.
     * Reimplementation of [android.graphics.Color.argb] for
     * API levels < 26.
     *
     * @param a alpha
     * @param r red
     * @param g green
     * @param b blue
     * @return color int
     */
    @ColorInt
    fun argb(a: Float, r: Float, g: Float, b: Float): Int {
        val A = float2int(a)
        val R = float2int(r)
        val G = float2int(g)
        val B = float2int(b)
        return argb(A, R, G, B)
    }

    /**
     * Encode ARGB values as a color int.
     * Reimplementation of [android.graphics.Color.argb] for
     * API levels < 26.
     *
     * @see [
     * Android developer reference: Color - Encoding](https://developer.android.com/reference/android/graphics/Color.encoding)
     *
     *
     * @param a alpha
     * @param r red
     * @param g green
     * @param b blue
     * @return color int
     */
    @ColorInt
    fun argb(a: Int, r: Int, g: Int, b: Int): Int {
        return a and 0xff shl 24 or (r and 0xff shl 16) or (g and 0xff shl 8) or (b and 0xff)
    }

    /**
     * Encode RGB values as a color int.
     * Reimplementation of [android.graphics.Color.rgb] for API levels
     * < 26.
     * @param r red
     * @param g green
     * @param b blue
     * @return color int
     */
    @ColorInt
    fun rgb(r: Float, g: Float, b: Float): Int {
        return argb(1f, r, g, b)
    }

    /**
     * Encode RGB values as a color int.
     * Reimplementation of [android.graphics.Color.rgb] for API levels
     * < 26.
     *
     * @param r red
     * @param g green
     * @param b blue
     * @return color int
     */
    @ColorInt
    fun rgb(r: Int, g: Int, b: Int): Int {
        return argb(255, r, g, b)
    }

    /**
     * Return the alpha component of the color.
     * Reimplementation of [android.graphics.Color.alpha] for APIs lower than 26.
     *
     * @param color color
     * @return alpha component
     *
     * @see [
     * Android developer reference: Color - Decoding](https://developer.android.com/reference/android/graphics/Color.decoding)
     */
    fun alpha(@ColorInt color: Int): Int {
        return color shr 24 and 0xff
    }

    /**
     * Return the red component of the color.
     * Reimplementation of [android.graphics.Color.red] for APIs lower than 26.
     *
     * @param color color
     * @return red component
     *
     * @see [
     * *     Android developer reference: Color - Decoding](https://developer.android.com/reference/android/graphics/Color.decoding)
     */
    fun red(@ColorInt color: Int): Int {
        return color shr 16 and 0xff
    }

    /**
     * Return the green component of the color.
     * Reimplementation of [android.graphics.Color.green] for APIs lower than 26.
     *
     * @param color color
     * @return green component
     *
     * @see [
     * *     Android developer reference: Color - Decoding](https://developer.android.com/reference/android/graphics/Color.decoding)
     */
    fun green(@ColorInt color: Int): Int {
        return color shr 8 and 0xff
    }

    /**
     * Return the blue component of the color.
     * Reimplementation of [android.graphics.Color.blue] for APIs lower than 26.
     *
     * @param color color
     * @return blue component
     *
     * @see [
     * *     Android developer reference: Color - Decoding](https://developer.android.com/reference/android/graphics/Color.decoding)
     */
    fun blue(@ColorInt color: Int): Int {
        return color and 0xff
    }

    private fun float2int(f: Float): Int {
        return Math.round(255 * f)
    }

    fun toString(color: Int): String {
        return "#" + String.format("%08x", color)
    }
}