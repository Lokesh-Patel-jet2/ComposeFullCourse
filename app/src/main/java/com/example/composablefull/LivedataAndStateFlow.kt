package com.example.composablefull

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow

class LiveDataCountViewModel : ViewModel(){

    private val _count = MutableLiveData(0)
    val count = _count

    fun increment(){
        _count.value = (_count.value ?: 0) + 1
    }


    fun decrement(){
        _count.value = (_count.value ?: 0) - 1
    }

}


@Composable
fun LiveCount(viewModel: LiveDataCountViewModel = viewModel()){

    val count by viewModel.count.observeAsState()

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text("Livedata Count : $count")

        Button(onClick = {viewModel.increment()}) {
            Text("Increase Count")
        }

        Button(onClick = {viewModel.decrement()}) {
            Text("Decrease Count")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLivedata(){
    LiveCount()
}


//=============================================================================
//=============================================================================


class StateFlowCountViewModel : ViewModel(){

    private val _count = MutableStateFlow(0)
    val count = _count

    fun increase(){
        _count.value = (_count.value?:0) + 1
    }


    fun decrease(){
        _count.value = (_count.value?:0) - 1
    }
}




@Composable
fun StateFloweCount(viewModel: StateFlowCountViewModel= viewModel()){

    val count by viewModel.count.collectAsState()

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text("StateFlow Count : $count")

        Button(onClick = {viewModel.increase()}) {
            Text("Increase Count")
        }

        Button(onClick = {viewModel.decrease()}) {
            Text("Decrease Count")
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun PreviewStateFlow(){

    StateFloweCount()
}





















