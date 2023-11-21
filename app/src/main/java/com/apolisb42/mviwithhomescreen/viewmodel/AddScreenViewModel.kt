package com.apolisb42.mviwithhomescreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apolisb42.mviwithhomescreen.model.dto.HomeData
import com.apolisb42.mviwithhomescreen.repository.IRepository
import com.apolisb42.mviwithhomescreen.repository.Repository
import kotlinx.coroutines.launch

class AddScreenViewModel(private val iRepository: IRepository):ViewModel() {

    private suspend fun insertHomeData(homeData: HomeData) = iRepository.insertHomeData(homeData)

    fun processIntent(intent: AddScreenIntent){
        when(intent){
            is AddScreenIntent.InsertDataIntent -> {
                viewModelScope.launch { insertHomeData(intent.homeData) }
            }
        }
    }

}

sealed class AddScreenIntent(){
    data class InsertDataIntent(val homeData: HomeData): AddScreenIntent()
}