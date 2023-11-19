package com.example.blocknotas2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blocknotas2023.DataBase.Mnotas.Notas
import com.example.blocknotas2023.DataBase.Mnotas.NotasDataBase
import com.example.blocknotas2023.components.BarraDeBusqueda
import com.example.blocknotas2023.navegation.Navegacion
import com.example.blocknotas2023.ui.theme.BlockNotas2023Theme
import com.example.blocknotas2023.viewModel.AudioViewModel
import com.example.blocknotas2023.viewModel.FotosViewModel
import com.example.blocknotas2023.viewModel.NotasDescriptivasViewModel
import com.example.blocknotas2023.viewModel.NotasViewModel
import com.example.blocknotas2023.viewModel.VideosViewModel
import com.example.blocknotas2023.Tarjetas.NotaCard
class Ventana1 : ComponentActivity() {
    private lateinit var db: NotasDataBase
    private val notasViewModel: NotasViewModel by viewModels()
    private val videosViewModel: VideosViewModel by viewModels()
    private val notasDescriptivasViewModel: NotasDescriptivasViewModel by viewModels()
    private val fotosViewModel: FotosViewModel by viewModels()
    private val audioViewModel: AudioViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = NotasDataBase.getDatabase(applicationContext)
        setContent {
            BlockNotas2023Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onPrimary
                ) {
                    Navegacion(
                        notasViewModel = notasViewModel,
                        videosViewModel = videosViewModel,
                        notasDescriptivasViewModel = notasDescriptivasViewModel,
                        fotosViewModel = fotosViewModel,
                        audioViewModel = audioViewModel
                    )
                }
            }
        }
    }
}
@Composable
fun ListaPrincipal(navController: NavController, notasViewModel: NotasViewModel) {
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    item {
                        NotaCard(
                            nota = Notas(title = "Título de la nota", content = "Contenido de la nota"),
                            onClick = {
                                navController.navigate("Notas")
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(600.dp))
                FloatingActionButton(
                    onClick = {
                        navController.navigate("Notas")
                    },
                    modifier = Modifier
                        .size(100.dp)
                        .padding(10.dp)
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

