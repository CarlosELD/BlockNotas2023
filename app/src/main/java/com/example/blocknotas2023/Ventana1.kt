package com.example.blocknotas2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blocknotas2023.components.BarraDeBusqueda
import com.example.blocknotas2023.navegation.Navegacion
import com.example.blocknotas2023.ui.theme.BlockNotas2023Theme

class Ventana1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlockNotas2023Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onPrimary
                ) {
                    Navegacion()
                }
            }
        }
    }
}

@Composable
fun ListaPrincipal(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { BarraDeBusqueda() }
    ) { padding ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.orange700)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.padding(20.dp).fillMaxHeight().fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(modifier = Modifier.fillMaxWidth()){

                }
                Spacer(modifier = Modifier.height(600.dp))
                FloatingActionButton(
                    onClick = {
                        navController.navigate("Notas")
                    },
                    modifier = Modifier.size(100.dp).padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.campana),
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
fun visualization1() {
    BlockNotas2023Theme {
        Navegacion()
    }
}
*/