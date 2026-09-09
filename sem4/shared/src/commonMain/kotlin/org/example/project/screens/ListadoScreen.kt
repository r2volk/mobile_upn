package org.example.project.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.example.project.Persona

@Composable
fun ListadoScreen(regresarHome:() -> Unit,personas: List<Persona>){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
        ) {
            items(personas){ persona ->
                Text(
                    text = "${persona.nombre} ${persona.apellido}",
                    modifier = Modifier.padding(16.dp)
                )
                HorizontalDivider()
            }
        }
        Button(
            onClick = {regresarHome()},
            modifier = Modifier.padding(15.dp)
        ){
            Text("Regresar")
        }
    }
}

@Preview
@Composable
fun ListadoScreenPreview(){
    ListadoScreen(
        regresarHome = {},
        personas = listOf()
    )
}