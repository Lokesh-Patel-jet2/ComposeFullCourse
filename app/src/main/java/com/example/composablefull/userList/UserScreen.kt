package com.example.composablefull.userList

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(viewModel: UserViewModel = viewModel()) {
    val users by viewModel.user.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchUser()
    }

    Scaffold (
        topBar = {
            TopAppBar(title = { Text("User List") })
        }
    ){
        if (users.isEmpty()){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
        else{
            LazyColumn (modifier = Modifier.padding(20.dp)){
                items(users){
                    Card (
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        elevation = CardDefaults.cardElevation(5.dp)
                    ){
                        Column (modifier = Modifier.padding(20.dp)){
                            Text(it.name, style = MaterialTheme.typography.titleMedium)
                            Text(it.email, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }
        }
    }

}
