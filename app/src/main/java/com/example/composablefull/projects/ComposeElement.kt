package com.example.composablefull.projects

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composablefull.Checkbox
import com.example.composablefull.DrawerContent
import com.example.composablefull.SnackBar
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun ComposableElement() {

    val drawerState =  rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var showDialog by remember { mutableStateOf(false) }
    var showSnackbar by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }
    var sliderValue by remember { mutableStateOf(0f) }
    var isChecked by remember { mutableStateOf(false) }
    var isSwitchOn by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf("Hello, Compose !!") }


    ModalNavigationDrawer(drawerState = drawerState,
        drawerContent = {
            DrawerContent { scope.launch { drawerState.open() } }
        }) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Jetpack Compose App") },
                    navigationIcon = {
                        IconButton(onClick = {scope.launch {
                            drawerState.open()
                        }}) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    showSnackbar = true
                }) {
                    Text("FAB")
                }
            },
            content = {paddingValues ->
                Column(
                    modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp)
                ) {

                    // TextField :-
                    BasicTextField(
                        value = textFieldValue,
                        onValueChange = {textFieldValue = it},
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text("Enter Text : $textFieldValue")


                    // Checkbox :-
                    Row (verticalAlignment = Alignment.CenterVertically){
                        androidx.compose.material3.Checkbox(
                            checked = isChecked,
                            onCheckedChange = {isChecked = it}
                        )

                        Text("I agree to the terms and conditions.")
                    }

                    // Switch
                    Row (verticalAlignment = Alignment.CenterVertically){
                        Switch(checked = isSwitchOn,
                            onCheckedChange = {isSwitchOn = it}
                        )

                        Text("Enable Notification")
                    }


                    // Slider
                    Text("Slider value : ${sliderValue.toInt()}")
                    Slider(
                        value = sliderValue,
                        onValueChange = {sliderValue = it},
                        valueRange = 0f..100f,
                        steps = 9
                    )


                    // LazyColumn :-
                    LazyColumn {
                        items(2){index ->
                            Card(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                                Surface (modifier = Modifier.padding(16.dp)){
                                    Text("Item $index")
                                }
                            }
                        }
                    }


                    // Buttons to show Dialog, Snackbox, BottomSheet
                    Button(onClick = {showDialog = true}) {
                        Text("Show Dialog")
                    }

                    Button(onClick = {showBottomSheet = true}) {
                        Text("Show BottomSheet")
                    }

                    Button(onClick = {showSnackbar = true}) {
                        Text("Show Snackbar")
                    }
                }


                // Dialog
                if (showDialog){
                    AlertDialog(
                        onDismissRequest = {showDialog = false},
                        title = { Text("Simple Dialog") },
                        text = { Text("This is a simple dialog !!") },
                        confirmButton = {
                            Button(onClick = {showDialog = false}) {
                                Text("OK")
                            }
                        }
                    )
                }

                // Snackbar
                if (showSnackbar){
                    Snackbar(
                        modifier = Modifier.padding(20.dp),
                        action = {
                            Button(onClick = {showSnackbar = false}) {
                                Text("Dismiss")
                            }
                        }
                    ){
                        Text("This is a Snackbar")
                    }
                }


                // BottomSheet
                if (showBottomSheet){
                    ModalBottomSheet(
                        onDismissRequest = {showBottomSheet = false}

                    ) {
                        Column (
                            modifier = Modifier.fillMaxWidth().padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text("This is BottomSheet")
                            Button(onClick = {showBottomSheet = false}) {
                                Text("Close")
                            }
                        }
                    }
                }
            }
        )
    }

}


@Composable
fun DrawerContent(onItemClick : () -> Unit){

    Column (modifier = Modifier.fillMaxSize().padding(20.dp)){
        Text("Lokesh Item 1", modifier = Modifier.padding(10.dp))
        Text("Lokesh Item 2", modifier = Modifier.padding(10.dp))
        Text("Lokesh Item 3", modifier = Modifier.padding(10.dp))
    }
}










