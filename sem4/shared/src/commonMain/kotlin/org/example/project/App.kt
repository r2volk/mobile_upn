package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.example.project.screens.HomeScreen
import org.example.project.screens.ListadoScreen
import org.example.project.screens.RegistrarScreen
import org.jetbrains.compose.resources.painterResource

import sem4.shared.generated.resources.Res
import sem4.shared.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var pantallaActual by remember { mutableStateOf("home") }
        var listaPersonas = remember { mutableStateListOf<Persona>() }

        when(pantallaActual){
            "home" -> HomeScreen(
                listarPersonas = {
                    pantallaActual = "listado"
                },
                registrarPersonas = {
                    pantallaActual = "registrar"
                }
            )
            "listado" -> ListadoScreen(
                regresarHome = {
                    pantallaActual = "home"
                },
                personas = listaPersonas
            )
            "registrar" -> RegistrarScreen(
                regresarHome = {
                    pantallaActual = "home"
                },
                onRegistrar = { nuevaPersona ->
                    listaPersonas.add(nuevaPersona)
                }
            )
        }
    }
}