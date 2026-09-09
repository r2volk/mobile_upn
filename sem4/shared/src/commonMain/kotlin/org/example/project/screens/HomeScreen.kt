package org.example.project.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.example.project.App


@Composable
fun HomeScreen(listarPersonas:() -> Unit, registrarPersonas:()-> Unit){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { registrarPersonas()}
        ){
            Text("Registrar")
        }
        Button(
            onClick = { listarPersonas() }
        ){
            Text("Listar")
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        listarPersonas = {},
        registrarPersonas = {}
    )
}