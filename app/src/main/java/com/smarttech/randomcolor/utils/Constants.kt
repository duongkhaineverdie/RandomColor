package com.smarttech.randomcolor.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import com.smarttech.randomcolor.data.model.ColorToShow
import kotlin.random.Random

object Constants {
    fun randomIntColor(): ColorToShow {
        val random = Random
        val red = random.nextInt(256)
        val green = random.nextInt(256)
        val blue = random.nextInt(256)
        val colorInt = Color.argb(255, red, green, blue)
        val colorHex = String.format("#%02X%02X%02X", red, green, blue)
        return ColorToShow(colorInt, colorHex)
    }

    fun copyClipboard(text: String, context: Context) {
        val clipboard = ContextCompat.getSystemService(context, ClipboardManager::class.java) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText("Copied Text", text)) // Correct usage
    }
}

