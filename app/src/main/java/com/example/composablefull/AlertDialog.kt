package com.example.composablefull

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showSystemUi = true)
@Composable
fun SimpleAlertDialog() {

    var showDialog by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = {showDialog = true}) {
            Text("Show Alert Dialog")
        }

        Screen(showDialog, onDismiss = {showDialog = false})
    }
}


@Composable
fun Screen(showDialog : Boolean, onDismiss: () -> Unit){

    if (showDialog){
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Alert Dialog") },
            text = { Text("This is a simple alert dialog in Jetpack Compose.") },
            confirmButton = {
                Button(onClick = onDismiss) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(onClick = onDismiss) {
                    Text("Cancel")
                }
            }
        )
    }
}



@Preview(showSystemUi = true)
@Composable
fun PreviewScreen(){
    SimpleAlertDialog()
}








