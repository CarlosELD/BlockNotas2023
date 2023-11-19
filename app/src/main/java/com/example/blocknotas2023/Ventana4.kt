package com.example.blocknotas2023

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blocknotas2023.viewModel.VideosViewModel

@Composable
fun Videos(navController: NavController, videosViewModel: VideosViewModel) {
    var value by remember { mutableStateOf("") }

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
                                videosViewModel.insertV(title = "", description = "Descripción del video", filePath = "ruta/del/archivo.mp4")
                            },
                            modifier = Modifier.padding(20.dp),
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        ) {
                            Text(text = "Tomar foto")
                        }
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.padding(20.dp),
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        ) {
                            Text(text = "Galeria")
                        }
                    }
                }
            }
        }
    }
}

