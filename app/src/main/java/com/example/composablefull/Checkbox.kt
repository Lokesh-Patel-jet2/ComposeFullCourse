package com.example.composablefull

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Preview(showSystemUi = true)
@Composable
fun Checkbox() {

    var isChecked by remember { mutableStateOf(false) }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ){
        androidx.compose.material3.Checkbox(
            checked = isChecked,
            onCheckedChange = {isChecked = it}
        )

        Text(text = if (isChecked) "Checked" else "Unchecked")
    }
}


@Preview(showSystemUi = true)
@Composable
fun MultipleCheckbox() {

    var options = listOf("Option1","Option2","Option3","Option4")
    val selectOption = remember { mutableStateMapOf<String, Boolean>() }

    options.forEach{options ->
        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()){
            androidx.compose.material3.Checkbox(
                checked = selectOption[options] ?: false,
                onCheckedChange = {selectOption[options] = it}
            )
        }

        Text(options)
    }

}






