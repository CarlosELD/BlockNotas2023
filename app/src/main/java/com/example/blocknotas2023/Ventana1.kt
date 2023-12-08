package com.example.blocknotas2023

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blocknotas2023.DataBase.Mcamara.MediaDatabase
import com.example.blocknotas2023.DataBase.Mcamara.MediaRepository
import com.example.blocknotas2023.DataBase.Mnotas.MensajesDataBase
import com.example.blocknotas2023.DataBase.Mnotas.RepositorioMsg
import com.example.blocknotas2023.Tarjetas.MensajeItem
import com.example.blocknotas2023.navegation.Navegacion
import com.example.blocknotas2023.ui.theme.BlockNotas2023Theme
import com.example.blocknotas2023.viewModel.AudioViewModel
import com.example.blocknotas2023.viewModel.MediaViewModel
import com.example.blocknotas2023.viewModel.MensajesViewModel

class Ventana1 : ComponentActivity() {
    private lateinit var db: MensajesDataBase
    private lateinit var db1: MediaDatabase
    lateinit var notasViewModel: MensajesViewModel
    lateinit var fotosViewModel: MediaViewModel
    private val audioViewModel: AudioViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = MensajesDataBase.getDatabase(applicationContext)
        db1 = MediaDatabase.getDatabase(applicationContext)
        notasViewModel = MensajesViewModel(RepositorioMsg(db.msgDao()))
        fotosViewModel = MediaViewModel(MediaRepository(db1.mediaDao()))
        setContent {
            BlockNotas2023Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onPrimary
                ) {
                    Navegacion(
                        mensajesViewModel = notasViewModel,
                        fotosViewModel = fotosViewModel,
                        audioViewModel = audioViewModel
                    )
                }
            }
        }
    }
}
@Composable
fun ListaPrincipal(navController: NavController, mensajesViewModel: MensajesViewModel) {
    val mensajeList by mensajesViewModel.mensajes.collectAsState(emptyList())
    var searchTerm by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TextField(
                value = searchTerm,
                onValueChange = {
                    searchTerm = it
                    mensajesViewModel.searchMensajes(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                label = { Text("Buscar mensajes") }
            )
        }
    ) { padding ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.orange700)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(20.dp)
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                FloatingActionButton(
                    onClick = {
                        navController.navigate("Notas")
                    },
                    modifier = Modifier
                        .size(70.dp)
                        .padding(10.dp).align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.campana),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(mensajeList) { mensaje ->
                        MensajeItem(
                            mensaje = mensaje,
                            onEliminarClick = {
                                mensajesViewModel.eliminarMensaje(it)
                            },
                            onEditarClick = {
                                try {
                                    navController.navigate("EditarMensaje/${it.id}")
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                            }
                        )
                    }
                }
            }
        }
    }
    DisposableEffect(Unit) {
        onDispose {
            mensajesViewModel.refreshList()
        }
    }
}
