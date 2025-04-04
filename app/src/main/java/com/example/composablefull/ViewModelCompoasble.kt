package com.example.composablefull

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelCompoasble : ViewModel(){

    var count by mutableStateOf(0)

    fun increment(){
        count++
    }

    fun decrement(){
        count--
    }
}



@Composable
fun Counter(counterViewModel : ViewModelCompoasble = viewModel()) {


    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text("Counter : ${counterViewModel.count}")

        Button(onClick = {counterViewModel.increment()}) {
            Text("Increment Count")
        }

        Button(onClick = {counterViewModel.decrement()}) {
            Text("Decrement Count")
        }

    }
}

//=======================================================================================================
//=======================================================================================================

class userViewModel : ViewModel(){

    private val _userName = MutableStateFlow("")
    val userName = _userName.asStateFlow()

    fun updateUsername(newName : String){
        _userName.value = newName
    }

}



@Composable

fun UserNameText(userViewModel: userViewModel = viewModel()){

    val user by userViewModel.userName.collectAsState()

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        TextField(value = user, onValueChange = {userViewModel.updateUsername(it)})
        Text("Enter Name : $user")
    }
}









