package com.example.blocknotas2023

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.blocknotas2023.ui.theme.BlockNotas2023Theme

@Composable
fun Controles(navController: NavController) {
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
/*
@Preview(showBackground = true)
@Composable
fun visualization3() {
    BlockNotas2023Theme {
        Controles()
    }
}
*/