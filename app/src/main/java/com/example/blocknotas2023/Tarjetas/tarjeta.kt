package com.example.blocknotas2023.Tarjetas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes

@Composable
fun MensajeItem(
    mensaje: Mensajes,
    onEliminarClick: (Mensajes) -> Unit,
    onEditarClick: (Mensajes) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = mensaje.title ?: "")
        Text(text = mensaje.contenido ?: "")
        Row {
            IconButton(onClick = {
                onEditarClick(mensaje)
            }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar")
            }
            IconButton(onClick = { onEliminarClick(mensaje) }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Eliminar")
            }
        }
    }
}

