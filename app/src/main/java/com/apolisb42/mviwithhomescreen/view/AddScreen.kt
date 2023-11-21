package com.apolisb42.mviwithhomescreen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import com.apolisb42.mviwithhomescreen.model.dto.HomeData
import com.apolisb42.mviwithhomescreen.repository.Repository
import com.apolisb42.mviwithhomescreen.view.NavRoutes.HOME_SCREEN
import com.apolisb42.mviwithhomescreen.viewmodel.AddScreenIntent
import com.apolisb42.mviwithhomescreen.viewmodel.AddScreenViewModel
import com.apolisb42.mviwithhomescreen.viewmodel.createFactory
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(viewModel: AddScreenViewModel, navController: NavController){

    val coroutineScope = rememberCoroutineScope()


    var firstName by remember{
        mutableStateOf("")
    }

    var age by remember {
        mutableStateOf("")
    }

    var homeTown by remember {
        mutableStateOf("")
    }
    
    Column {
        Text(text = "FirstName")
        TextField(value = firstName, onValueChange = {firstName = it})
        Text(text = "Age")
        TextField(value = age, onValueChange = {age = it})
        Text(text = "homeTown")
        TextField(value = homeTown, onValueChange = {homeTown = it})
        Button(onClick = {
            coroutineScope.launch {
                insertHomeDAta(name = firstName, age = age, homeTown = homeTown,viewModel )
            }
            navController.navigate(HOME_SCREEN)

        }) {
            Text(text = "insert data")
        }
    }
}

private suspend fun insertHomeDAta(
    name:String,
    age:String,
    homeTown:String,
    viewModel:AddScreenViewModel
){
    val homeData = HomeData(
        name = name,
        age = age,
        homeTown = homeTown
    )
    viewModel.processIntent(AddScreenIntent.InsertDataIntent(homeData))
}