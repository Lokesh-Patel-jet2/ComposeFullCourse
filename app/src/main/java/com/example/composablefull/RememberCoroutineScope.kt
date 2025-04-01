package com.example.composablefull

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


@Preview(showSystemUi = true)
@Composable
fun RememberCoroutineScope() {

    val scope = rememberCoroutineScope()
    var buttonText by remember { mutableStateOf("Hello") }

    Button(
        onClick = {
            scope.launch {
                delay(2000)
                buttonText = "World"
            }
        }
    ) {
        Text(buttonText)
    }
}



@Preview(showSystemUi = true)
@Composable
fun ComposableRememberUpdateState(){
    var count by remember { mutableStateOf(0) }

        Column (horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()){
            Button(onClick = {
                count = Random.nextInt(1, 100)
            }) {
                Text(text = "Click")
                Log.d("value", "Random Count $count")
            }
        }

    ShowUpdatedValue(count)
}

@Composable
fun ShowUpdatedValue(count: Int) {
    val updatedCount = rememberUpdatedState(count)
    LaunchedEffect (key1 = Unit){
        delay(10000)
        Log.d("value", "Updated Count ${updatedCount.value}")
    }
}
