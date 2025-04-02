package com.example.composablefull

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Home Screen", fontSize = 25.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("detail/lokesh") }) {
            Text("Go To Details with name")
        }
    }
}


@Composable
fun DetailScreen(navController: NavController, name: String?) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Detail Screen and the name is $name", fontSize = 25.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Go To Home")
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController, "home") {
        composable("home") { HomeScreen(navController) }
        composable("detail/{name}") { DetailScreen(navController, it.arguments?.getString("name")) }
    }
}