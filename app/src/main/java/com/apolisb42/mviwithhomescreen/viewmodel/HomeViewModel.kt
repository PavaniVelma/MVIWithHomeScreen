package com.apolisb42.mviwithhomescreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apolisb42.mviwithhomescreen.model.dto.HomeData
import com.apolisb42.mviwithhomescreen.repository.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(private val iRepository: IRepository):ViewModel() {
    private val _stateFlow = MutableStateFlow<List<HomeData>>(ArrayList())
    val stateFlow: StateFlow<List<HomeData>> = _stateFlow
    private fun fetchData(){
        viewModelScope.launch(Dispatchers.IO){
            iRepository.getHomeData().collectLatest {
                _stateFlow.value = it
            }
        }
    }

    fun processIntent(intent: HomeScreenIntent){
        when(intent){
            is HomeScreenIntent.FetchIntent ->{
                fetchData()
            }
        }
    }
}

sealed class HomeScreenIntent(){
    object FetchIntent : HomeScreenIntent()
}