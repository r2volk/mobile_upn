package org.sem3.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sem3.project.model.Venta
import org.sem3.project.components.SimpleDropdown

@Composable
@Preview
fun App() {

    val marcas = listOf("NIKE", "ADIDAS", "FILA")
    val tallas = listOf("TALLA 38", "TALLA 40", "TALLA 42")
    var ventaState by remember { mutableStateOf(Venta()) }

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
                horizontalAlignment = Alignment.Start,
            ){
                Text("Elegir Marca:", modifier = Modifier.padding(bottom = 10.dp), fontSize = 25.sp)
                SimpleDropdown(
                    label = "Marca",
                    opciones = marcas,
                    seleccionado = ventaState.marca,
                    onSeleccion = {ventaState = ventaState.copy(marca = it)}
                )
            }

            Column(
                horizontalAlignment = Alignment.Start,
            ){
                Text("Elegir Talla:", modifier = Modifier.padding(bottom = 10.dp), fontSize = 25.sp)
                SimpleDropdown(
                    label = "Talla",
                    opciones = tallas,
                    seleccionado = ventaState.talla,
                    onSeleccion = {ventaState = ventaState.copy(talla = it)}
                )
            }

            Column(
                horizontalAlignment = Alignment.Start,
            ){
                Text("Numero de pares vendidos:", modifier = Modifier.padding(bottom = 10.dp), fontSize = 20.sp)
                TextField(
                    value = ventaState.cantidadTexto,
                    onValueChange = {ventaState = ventaState.copy(cantidadTexto = it)},
                    label = {Text("Cantidad")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black),
                    modifier = Modifier.padding(bottom = 10.dp),
                    onClick = {
                        ventaState = CalculadoraVenta.procesar(ventaState)
                    }
                ){
                    Text("CALCULAR")
                }

                Column(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .background(Color.White)
                        .padding(20.dp)
                ){
                    Text(
                        text = "Costo del par de zapatillas: ${ventaState.costoUnitario}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "La venta de la zapatilla: ${ventaState.ventaBruta}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Descuento: ${ventaState.descuento}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "La venta neta: ${ventaState.ventaNeta}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                }

            }

        }

    }
}