package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import kotlinx.coroutines.launch

import org.jetbrains.compose.resources.painterResource

import sem2.shared.generated.resources.Res
import sem2.shared.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var n1 by remember { mutableStateOf("") }
        var n2 by remember { mutableStateOf("") }

        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
        ) {
            Text(
                text = "Curso Aplicaciones Mobiles",
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                textAlign = TextAlign.Center
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Ingresa el primer numero: ",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(20.dp)
                )
                TextField(
                    value = n1,
                    onValueChange = {n1 = it}
                )
                Text(
                    text = "Ingresa el segundo numero: ",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(20.dp)
                )
                TextField(
                    value = n2,
                    onValueChange = {n2 = it}
                )
                Column(
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Button(onClick = {
                            var resultado = n1.toFloat() * n2.toFloat()
                            scope.launch {
                                snackbarHostState.showSnackbar("Resultado: ${resultado}")
                            }
                        }){
                            Text("X")
                        }
                        Button(onClick = {
                            var resultado = n1.toFloat() / n2.toFloat()
                            scope.launch {
                                snackbarHostState.showSnackbar("Resultado: ${resultado}")
                            }
                        }){
                            Text("/")
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Button(onClick = {
                            var resultado = n1.toFloat() + n2.toFloat()
                            scope.launch {
                                snackbarHostState.showSnackbar("Resultado: ${resultado}")
                            }
                        }){
                            Text("+")
                        }
                        Button(onClick = {
                            var resultado = n1.toFloat() - n2.toFloat()
                            scope.launch {
                                snackbarHostState.showSnackbar("Resultado: ${resultado}")
                            }
                        }){
                            Text("-")
                        }
                    }

                }
            }
            SnackbarHost(snackbarHostState)
        }
    }
}