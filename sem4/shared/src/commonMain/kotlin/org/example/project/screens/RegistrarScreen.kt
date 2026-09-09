package org.example.project.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.Persona

@Composable
fun RegistrarScreen(
    regresarHome:()-> Unit,
    onRegistrar:(Persona)-> Unit){

    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var borrarTextos by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ){
            Text(
                text = "Ingresa el nombre: ",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            TextField(
                value = nombre,
                onValueChange = {nombre = it}
            )
        }

        Column (
            modifier = Modifier.padding(20.dp)
        ){
            Text(
                text = "Ingresa el apellido: ",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            TextField(
                value = apellido,
                onValueChange = {apellido = it}
            )
        }

        Row(
            modifier = Modifier.padding(15.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Button(
                onClick = {
                    if (nombre.isNotBlank() && apellido.isNotBlank()){
                        onRegistrar(Persona(nombre,apellido))
                    }
                    nombre = ""
                    apellido = ""
                }
            ){
                Text("Registrar")
            }
            Button(
                onClick = {
                    regresarHome()}
            ){
                Text("Regresar")
            }
        }
    }
}

@Preview
@Composable
fun RegistrarScreenPreview() {
    RegistrarScreen(
        regresarHome = {},
        onRegistrar = {}
    )
}