package com.example.blocknotas2023

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blocknotas2023.ui.theme.BlockNotas2023Theme

class Ventana5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlockNotas2023Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onPrimary
                ) {
                    /*Greeting("Android")*/
                    NotasDescriptivas()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotasDescriptivas() {
    var text by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
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
                    value = text,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { text = it },
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    label = { Text(text = "Contenido") },
                    value = value,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { value = it },
                    maxLines = 5
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Fecha")
                }
                TextField(
                    label = { Text("") },
                    value = text,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { text = it },
                    maxLines = 1
                )
                Button(
                    onClick = { },
                    modifier = Modifier.padding(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Hora")
                }
                TextField(
                    label = { Text("") },
                    value = text,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { text = it },
                    maxLines = 1
                )
                Button(
                    onClick = { },
                    modifier = Modifier.padding(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Guardar")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun visualization5() {
    BlockNotas2023Theme {
        NotasDescriptivas()
    }
}
