package com.example.blocknotas2023

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blocknotas2023.viewModel.MensajesViewModel

@Composable
fun Controles(navController: NavController, notasViewModel: MensajesViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.orange700)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                FloatingActionButton(
                    onClick = { navController.navigate("ListaPrincipal") },
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
                    onClick = { navController.navigate("Videos") },
                    modifier = Modifier
                        .size(110.dp)
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.videos),
                        contentDescription = null
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                FloatingActionButton(
                    onClick = { navController.navigate("CamaraFotografica") },
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
                    onClick = { navController.navigate("GrabandoAudio") },
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
}
