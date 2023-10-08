package com.example.blocknotas2023

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blocknotas2023.ui.theme.BlockNotas2023Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Controles() {
    var text by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.orange700)
    ) {
        Column (
            modifier = Modifier
                .padding(20.dp)
                .fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(110.dp)
                    .padding(10.dp)
            ) {
                   Image(
                       painter = painterResource(id = R.drawable.historial),
                       contentDescription = null
                   )
            }
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(110.dp)
                    .padding(10.dp)
            ) {
                   Image(
                       painter = painterResource(id = R.drawable.videos),
                       contentDescription = null
                   )
            }
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(110.dp)
                    .padding(10.dp)
            ) {
                   Image(
                       painter = painterResource(id = R.drawable.fotos),
                       contentDescription = null
                   )
            }
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(110.dp)
                    .padding(10.dp)
            ) {
                   Image(
                       painter = painterResource(id = R.drawable.musica),
                       contentDescription = null
                   )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun visualization3() {
    BlockNotas2023Theme {
        Controles()
    }
}