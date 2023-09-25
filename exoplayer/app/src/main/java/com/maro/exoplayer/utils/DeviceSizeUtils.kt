package com.maro.exoplayer.utils

import android.content.Context

object DeviceSizeUtils {

    private fun getDpWidth(context: Context): Float {
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.widthPixels / displayMetrics.density
    }

    fun calculateHeight(context: Context): Float {
        val dpWidth = getDpWidth(context = context)
        return dpWidth / 16F * 9F
    }

}