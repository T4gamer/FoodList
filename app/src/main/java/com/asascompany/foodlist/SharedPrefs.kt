package com.asascompany.foodlist

import android.content.Context

class SharedPrefs(context: Context) {

    companion object {
        private const val FILE_KEY = "font_info"
        private const val FONT_SIZE = "size"
    }

    private val sharedPref = context.getSharedPreferences(FILE_KEY, Context.MODE_PRIVATE)

    fun saveFontSize(size: String){
        sharedPref.edit()
            .putString(FONT_SIZE, size)
            .apply()
    }

    fun getFontSize(): Float {
        var size = 0f
        when(sharedPref.getString(FONT_SIZE, "small")?:"small"){
            "small" -> 20f
            "medium" -> 40f
            "large" -> 60f
        }
        return size
    }
}