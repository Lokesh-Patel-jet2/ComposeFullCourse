package com.example.composablefull

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Preview(showSystemUi = true)
@Composable
fun SnackBar(){
    var snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = {
            scope.launch {
                val result = snackbarHostState.showSnackbar("Item Deeleted",
                    actionLabel = "Undo",
                    duration = SnackbarDuration.Short)

                if (result == SnackbarResult.ActionPerformed){
                    println("Undo Clicked !!")
                }
            }
        }) {
            Text("Show Snackbar")
        }

        SnackbarHost(hostState = snackbarHostState)
    }
}