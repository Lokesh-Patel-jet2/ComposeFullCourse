package com.example.composablefull

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composablefull.projects.ComposableElement
import com.example.composablefull.projects.NoteCounterApp
import com.example.composablefull.ui.theme.ComposableFullTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposableFullTheme {
//                Basic()
//                Buttons()
//                StateHoisting()
//                NoteCounterApp()
//                SideEffect()
//                ComposableRememberUpdateState()
//                TextFieldValidation()
//                MultipleCheckbox()
//                Switch()
//                Slider()
//                LazyColumnsData()
//                SimpleAlertDialog()
//                SimpleScaffold()
//                SimpleDrawer()
//                ComposableElement()
//                AppNavigation()
                Counter()
                UserNameText()
            }
        }
    }
}
