package com.example.blocknotas2023

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blocknotas2023.DataBase.Mcamara.Foto
import com.example.blocknotas2023.viewModel.FotosViewModel

@Composable
fun CamaraFotografica(navController: NavController, fotosViewModel: FotosViewModel) {
    var value by remember { mutableStateOf("") }
    val fotos by fotosViewModel.allFotos.collectAsState(emptyList())

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
                Spacer(modifier = Modifier.padding(40.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    FloatingActionButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .size(150.dp)
                            .padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.campana),
                            contentDescription = null
                        )
                    }
                }
                Spacer(modifier = Modifier.height(50.dp))
                TextField(
                    label = { Text(text = "Descripción") },
                    value = value,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { value = it },
                    maxLines = 5
                )
                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = { /* TODO */ },
                            modifier = Modifier.padding(20.dp),
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        ) {
                            Text(text = "Grabar audio")
                        }

                        Button(
                            onClick = {
                                val foto = Foto(descripcion = value, ruta = "ruta_de_la_foto") // Ajusta la ruta según tus necesidades
                                fotosViewModel.addFoto(foto)
                                navController.navigate("ListaPrincipal")
                            },
                            modifier = Modifier.padding(20.dp),
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        ) {
                            Text(text = "Guardar")
                        }
                    }
                }

                // Muestra las fotos almacenadas
                Spacer(modifier = Modifier.height(20.dp))
                Text("Fotos almacenadas:")
                LazyColumn {
                    items(fotos) { foto ->
                        Text(text = foto.descripcion)
                    }
                }
            }
        }
    }
}