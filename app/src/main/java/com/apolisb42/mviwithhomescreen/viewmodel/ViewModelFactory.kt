package com.apolisb42.mviwithhomescreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun <T: ViewModel> T.createFactory(): ViewModelProvider.Factory{
    val viewModel =  this
    return object : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>) = viewModel as T
    }
}