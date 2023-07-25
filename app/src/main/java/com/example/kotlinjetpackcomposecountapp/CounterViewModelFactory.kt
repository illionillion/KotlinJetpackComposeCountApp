package com.example.kotlinjetpackcomposecountapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CounterViewModelFactory(private val counterPreferences: CounterPreferences) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CounterViewModel(counterPreferences) as T
    }
}

