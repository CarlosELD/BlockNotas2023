package com.example.blocknotas2023

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes
import com.example.blocknotas2023.viewModel.MensajesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarMensaje(
    mensaje: Mensajes,
    mensajesViewModel: MensajesViewModel,
    navController: NavController
) {
    val mensajeId = navController.previousBackStackEntry?.arguments?.getString("id")
    val mensajeSeleccionado: Mensajes? = mensajesViewModel.mensajes.firstOrNull { it.id.toString() == mensajeId }
    var nuevoTitulo by remember { mutableStateOf(mensaje.title) }
    var nuevoContenido by remember { mutableStateOf(mensaje.contenido) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Editar Mensaje") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            mensajeSeleccionado?.let { mensaje ->
                TextField(
                    value = nuevoTitulo,
                    onValueChange = { nuevoTitulo = it },
                    label = { Text("Título") },
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = nuevoContenido,
                    onValueChange = { nuevoContenido = it },
                    label = { Text("Contenido") }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    // Guardar los cambios en el ViewModel
                    mensajeSeleccionado?.let {
                        mensajesViewModel.actualizarMensaje(
                            it.copy(title = nuevoTitulo, contenido = nuevoContenido)
                        )
                    }
                    // Navegar de nuevo a la lista principal
                    navController.navigate("ListaPrincipal")
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Guardar cambios")
            }
        }
    }
}