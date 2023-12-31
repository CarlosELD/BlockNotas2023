package com.example.blocknotas2023

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes
import com.example.blocknotas2023.viewModel.MensajesViewModel
import com.example.blocknotas2023.viewModel.establecerAlarmaYNotificacion
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarMensaje(
    mensaje: Mensajes,
    mensajesViewModel: MensajesViewModel,
    navController: NavController
) {
    var nuevoTitulo by remember { mutableStateOf(mensaje.title) }
    var nuevoContenido by remember { mutableStateOf(mensaje.contenido) }
    val contexto = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Editar Mensaje", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Surface(
            modifier = Modifier.fillMaxSize().padding(padding),
            color = colorResource(id = R.color.orange700)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = nuevoTitulo,
                        onValueChange = { nuevoTitulo = it },
                        label = { Text("Título", color = Color.Gray) },
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        textStyle = TextStyle(color = Color.Black),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = nuevoContenido,
                        onValueChange = { nuevoContenido = it },
                        label = { Text("Contenido", color = Color.Gray) },
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        textStyle = TextStyle(color = Color.Black),
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            val mensajeEditado = Mensajes(
                                id = mensaje.id,
                                title = nuevoTitulo,
                                contenido = nuevoContenido
                            )
                            mensajesViewModel.editarMensaje(mensajeEditado)
                            val currentTime = Calendar.getInstance().timeInMillis
                            val alarmTime = currentTime + 10 * 1000
                            mensajesViewModel.insertarConAlarma(
                                mensajeEditado,
                                alarmTime,
                                context = contexto
                            )
                            establecerAlarmaYNotificacion(
                                mensajeEditado.id.toLong(),
                                mensajeEditado.title,
                                contexto
                            )
                            navController.navigate("ListaPrincipal")
                        },
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text("Guardar cambios", color = Color.White)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}