package com.example.composablefull

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Preview(showSystemUi = true)
@Composable
fun Switch() {
    var isSwitch by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize(),
        ) {

        Row {
            Text("Dark Mode")

            Spacer(modifier = Modifier.weight(1f))
            androidx.compose.material3.Switch(
                checked = isSwitch,
                onCheckedChange = {isSwitch = it}
            )
        }
    }
}