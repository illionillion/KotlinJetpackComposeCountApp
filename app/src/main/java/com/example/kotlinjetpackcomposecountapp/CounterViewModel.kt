package com.example.kotlinjetpackcomposecountapp

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CounterViewModel(private val counterPreferences: CounterPreferences) : ViewModel() {
    private var _count by mutableStateOf(counterPreferences.getCount())

    fun getCount(): Int {
        return _count
    }

    fun increment() {
        _count++
        updateCountInPreferences()
    }

    fun decrement() {
        if (_count > 0) {
            _count--
            updateCountInPreferences()
        }
    }

    fun reset() {
        _count = 0
        updateCountInPreferences()
    }

    private fun updateCountInPreferences() {
        viewModelScope.launch {
            counterPreferences.setCount(_count)
        }
    }

}