package com.example.blocknotas2023

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.blocknotas2023.DataBase.Mgrabadora.graba
import com.example.blocknotas2023.viewModel.AudioViewModel

@Composable
fun GrabandoAudio(AudioViewModel: AudioViewModel, navController: NavHostController) {
    var value by remember { mutableStateOf("") }
    val audios by AudioViewModel.allAudios.collectAsState(emptyList())

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
                Spacer(modifier = Modifier.height(400.dp))
                TextField(
                    label = { Text(text = "Descripción") },
                    value = value,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { value = it },
                    maxLines = 5
                )
                Spacer(modifier = Modifier.height(100.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = {
                                val audio = graba(descripcion = value)
                                AudioViewModel.addAudio(audio)
                                navController.navigate("ListaPrincipal")
                            },
                            modifier = Modifier.padding(20.dp),
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        ) {
                            Text(text = "Tomar foto")
                        }
                        Button(
                            onClick = { /* TODO */ },
                            modifier = Modifier.padding(20.dp),
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        ) {
                            Text(text = "Galeria")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text("Audios almacenados:")
                LazyColumn {
                    items(audios) { audio ->
                        Text(text = audio.descripcion)
                    }
                }
            }
        }
    }
}

