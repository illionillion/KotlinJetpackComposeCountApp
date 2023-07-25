package com.example.kotlinjetpackcomposecountapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var _count by mutableStateOf(0)

    fun getCount(): Int {
        return _count
    }

    fun increment() {
        _count++
    }

    fun decrement() {
        if (_count > 0) {
            _count--
        }
    }

    fun reset() {
        _count = 0
    }
}