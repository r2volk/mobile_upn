package org.sem3.project.components

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class) // permite usar api experimental de material3
@Composable // marca funcion como ui redibujable
fun SimpleDropdown( // dropdown reutilizable tipo spinner
    label: String, // titulo flotante del campo
    opciones: List<String>, // lista de opciones a mostrar
    seleccionado: String, // valor actual (lo guarda el padre)
    onSeleccion: (String) -> Unit, // callback para avisar que eligio
    modifier: Modifier = Modifier // modificador externo opcional
){
    var expanded by remember { mutableStateOf(false) } // false = cerrado, true = abierto

    ExposedDropdownMenuBox( // caja que coordina campo + menu
        expanded = expanded, // estado compartido actual
        onExpandedChange = {expanded = !expanded} // al tocar: invierte abrir/cerrar
    ){
        TextField( // campo visible siempre
            value = seleccionado, // muestra el valor elegido
            onValueChange = {}, // vacio porque es solo lectura
            readOnly = true, // bloquea teclado, solo abre menu
            label = {Text(label)}, // textito superior del campo
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)}, // flechita que rota sola
            colors = ExposedDropdownMenuDefaults.textFieldColors(), // colores material del dropdown
            modifier = modifier.menuAnchor() // ancla el menu debajo del campo
        )
        ExposedDropdownMenu( // ventanita flotante con la lista
            expanded = expanded, // solo se dibuja si es true
            onDismissRequest = {expanded = false} // toco fuera: cerrar menu
        ){
            opciones.forEach { opcion -> // repite una fila por cada opcion
                DropdownMenuItem( // fila clicable del menu
                    text = {Text(opcion)}, // texto visible de la opcion
                    onClick = { // al tocar una opcion:
                        onSeleccion(opcion) // 1. avisa al padre
                        expanded = false // 2. cierra el menu
                    }
                )

            }
        }
    }
}
