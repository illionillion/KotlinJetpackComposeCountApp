package com.example.kotlinjetpackcomposecountapp

import android.content.Context

class CounterPreferences(context: Context) {
    private val prefs = context.getSharedPreferences("counter_prefs", Context.MODE_PRIVATE)

    fun getCount(): Int {
        return prefs.getInt("count", 0)
    }

    fun setCount(count: Int) {
        prefs.edit().putInt("count", count).apply()
    }
}
