package com.apolisb42.mviwithhomescreen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.apolisb42.mviwithhomescreen.model.dto.HomeData
import com.apolisb42.mviwithhomescreen.view.NavRoutes.ADD_SCREEN
import com.apolisb42.mviwithhomescreen.viewmodel.HomeScreenIntent
import com.apolisb42.mviwithhomescreen.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(viewModel: HomeViewModel, navController: NavController){

    var item = viewModel.stateFlow.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.processIntent(HomeScreenIntent.FetchIntent)
    }
    Column {
        SmallFloatingActionButton(onClick = { navController.navigate(ADD_SCREEN) }) {
            Icon(Icons.Filled.Add, contentDescription = "Small Floating Action Button")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        LazyColumn() {
            items(item.value) {
                ListOfItems(homeData = it)
            }
        }
    }

}

@Composable
fun ListOfItems(homeData: HomeData){

    Card(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight().padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text =homeData.name )
            Text(text =homeData.age )
            Text(text =homeData.homeTown )
        }
    }
}