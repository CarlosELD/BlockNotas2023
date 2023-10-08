package com.example.blocknotas2023

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blocknotas2023.ui.theme.BlockNotas2023Theme

class Ventana2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlockNotas2023Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onPrimary
                ) {
                    /*Greeting("Android")*/
                    Notas()
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Notas() {
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
                    .fillMaxHeight()
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
                    modifier = Modifier.width(400.dp),
                    onValueChange = { text = it },
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(40.dp))
                TextField(
                    label = { Text(text = "Descripción") },
                    value = value,
                    modifier = Modifier.width(400.dp),
                    onValueChange = { value = it },
                    maxLines = 5
                )
                Spacer(modifier = Modifier.height(100.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Top
                        ) {
                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .padding(10.dp),
                                colors = ButtonDefaults.buttonColors(Color.Red)
                            ) {
                                Text(text = "Guardar")
                            }
                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .padding(10.dp),
                                colors = ButtonDefaults.buttonColors(Color.Red)
                            ) {
                                Text(text = "Cancelar")
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.Top
                            ) {
                                FloatingActionButton(
                                    onClick = { },
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
                                    onClick = { },
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
    }
}

@Preview(showBackground = true)
@Composable
fun visualization2() {
    BlockNotas2023Theme {
        Notas()
    }
}
