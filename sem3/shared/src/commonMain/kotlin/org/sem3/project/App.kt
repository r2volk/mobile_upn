package org.sem3.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import org.sem3.project.components.SimpleDropdown
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

import sem3.shared.generated.resources.Res
import sem3.shared.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {

    var seleccionado by remember { mutableStateOf("Perú") }
    val paises = listOf("Perú", "Chile", "Argentina")

    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(color = Color.Green)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text("Elegir Marca:")
                SimpleDropdown(
                    label = "País",
                    opciones = paises,
                    seleccionado = seleccionado,
                    onSeleccion = { nuevoValor -> seleccionado = nuevoValor  }
                )

            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black),
                    onClick = { showContent = !showContent }
                ){
                    Text("Boton3")
                }

                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black),
                    onClick = { showContent = !showContent }
                ){
                    Text("Boton4")
                }
            }

        }

    }
}