package com.example.composablefull

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showSystemUi = true)
@Composable
fun LazyColumns() {

    LazyColumn {
        items(50){
            Text("Item No. $it",
                modifier = Modifier.padding(20.dp),
                fontSize = 20.sp)
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun LazyColumnsList() {
    val itemList = listOf("Android", "Kotlin", "Jetpack Compose", "LazyColumn")

    LazyColumn {
        items(itemList){
            Card (modifier = Modifier.fillMaxWidth().padding(10.dp),
                elevation = CardDefaults.cardElevation(5.dp)){
                Text("$it",
                    modifier = Modifier.padding(20.dp),
                    fontSize = 20.sp)
            }
        }
    }
}


data class User(val name : String, val age : Int)
@Preview(showSystemUi = true)
@Composable
fun LazyColumnsData() {

    val users = listOf(
        User("Lokesh", 23),
        User("Aditya", 22),
        User("Linktech", 19),
    )

    LazyColumn (modifier = Modifier.padding(top=70.dp)){
        items(users){
            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
               ){
                Text(it.name,
                    modifier = Modifier.padding(20.dp)
                        .clickable { Log.d("click","$it Clicked !!") },
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.weight(1f))

                Text("${it.age}",
                    modifier = Modifier.padding(20.dp)
                        .clickable { Log.d("click","$it Clicked !!") },
                    fontSize = 20.sp
                )
            }

            Divider(modifier = Modifier.height(2.dp))
        }
    }
}

