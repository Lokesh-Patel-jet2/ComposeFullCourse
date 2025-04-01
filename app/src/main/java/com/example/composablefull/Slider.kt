package com.example.composablefull

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
fun Slider() {

    var slideValue by remember { mutableStateOf(0f) }


    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 70.dp).padding(horizontal = 30.dp)
    ){
        androidx.compose.material3.Slider(
            value = slideValue,
            onValueChange = {slideValue = it},
            valueRange = 0f..10f,
            steps = 9
        )

        Text("Slider : ${slideValue.toInt()}")
    }
}