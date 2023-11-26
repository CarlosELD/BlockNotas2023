package com.example.blocknotas2023

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes
import com.example.blocknotas2023.viewModel.MensajesViewModel
import kotlinx.coroutines.launch

@Composable
fun Notas(
    navController: NavController,
    viewModel: MensajesViewModel
) {
    var text by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Surface(
            modifier = Modifier.fillMaxSize().padding(padding),
            color = colorResource(id = R.color.orange700)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Notas",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(30.dp))
                TextField(
                    label = { Text("Titulo") },
                    value = text,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { text = it },
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(40.dp))
                TextField(
                    label = { Text(text = "Descripción") },
                    value = value,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { value = it },
                    maxLines = 5
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            viewModel.viewModelScope.launch {
                                try {
                                    viewModel.insertar(Mensajes(id = 0, title = text, contenido = value))
                                    text = ""
                                    value = ""
                                    navController.navigate("ListaPrincipal")
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                            }
                        },
                        modifier = Modifier
                            .padding(10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red)
                    ) {
                        Text(text = "Guardar")
                    }
                    Button(
                        onClick = { navController.navigate("ListaPrincipal") },
                        modifier = Modifier
                            .padding(10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red)
                    ) {
                        Text(text = "Cancelar")
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FloatingActionButton(
                            onClick = { navController.navigate("NotasDescriptivas") },
                            modifier = Modifier
                                .size(55.dp)
                                .padding(10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.campana),
                                contentDescription = null
                            )
                        }
                        FloatingActionButton(
                            onClick = { navController.navigate("Controles") },
                            modifier = Modifier
                                .size(55.dp)
                                .padding(10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.archivos),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}
