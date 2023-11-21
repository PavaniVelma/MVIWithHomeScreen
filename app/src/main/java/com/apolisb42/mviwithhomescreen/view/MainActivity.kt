package com.apolisb42.mviwithhomescreen.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.apolisb42.mviwithhomescreen.model.AppDatabase.Companion.getAppDatabase
import com.apolisb42.mviwithhomescreen.model.dao.HomeDao
import com.apolisb42.mviwithhomescreen.repository.IRepository
import com.apolisb42.mviwithhomescreen.repository.Repository
import com.apolisb42.mviwithhomescreen.ui.theme.MVIWithHomeScreenTheme
import com.apolisb42.mviwithhomescreen.viewmodel.AddScreenViewModel
import com.apolisb42.mviwithhomescreen.viewmodel.HomeViewModel
import com.apolisb42.mviwithhomescreen.viewmodel.createFactory

class MainActivity : ComponentActivity() {

    lateinit var repository: IRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeDao = getAppDatabase(this)?.getHomeData()!!
        repository = Repository(homeDao)
        setContent {
            val factory = AddScreenViewModel(repository).createFactory()
            val factory1 = HomeViewModel(repository).createFactory()
            val addScreenViewModel : AddScreenViewModel = viewModel(factory =factory)
            val homeScreenViewModel : HomeViewModel = viewModel(factory =factory1)
            MVIWithHomeScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(viewModel = addScreenViewModel, viewModel1 = homeScreenViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVIWithHomeScreenTheme {
        Greeting("Android")
    }
}