package com.example.blocknotas2023

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blocknotas2023.viewModel.NotasDescriptivasViewModel
import com.google.type.Date
import java.text.SimpleDateFormat
import java.util.Calendar

@Composable
fun NotasDescriptivas(
    title: String,
    content: String,
    fecha: String,
    hora: String,
    navController: NavController,
    NotasDescriptivasViewModel: NotasDescriptivasViewModel
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    val selectedDate by remember { mutableStateOf<Date?>(null) }
    val selectedTime by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current
    var isDatePickerVisible by remember { mutableStateOf(false) }
    var isTimePickerVisible by remember { mutableStateOf(false) }
    val selectedCalendar = Calendar.getInstance()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.orange700)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                TextField(
                    label = { Text("Titulo") },
                    value = title,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { title = it },
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    label = { Text(text = "Contenido") },
                    value = content,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { content = it },
                    maxLines = 5
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { isDatePickerVisible = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Fecha")
                }
                selectedDate?.let { date ->
                    Text(
                        text = "Fecha seleccionada: ${SimpleDateFormat("dd/MM/yyyy").format(date)}",
                        modifier = Modifier.padding(5.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { isTimePickerVisible = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Hora")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        if (selectedDate != null && selectedTime != null) {
                            val timeParts = selectedTime!!.split(":")
                            selectedCalendar.set(Calendar.HOUR_OF_DAY, timeParts[0].toInt())
                            selectedCalendar.set(Calendar.MINUTE, timeParts[1].toInt())
                            navController.navigate("ListaPrincipal")
                        } else {
                            Toast.makeText(context, "Por favor, selecciona fecha y hora", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Guardar")
                }
            }
        }
    }
}



