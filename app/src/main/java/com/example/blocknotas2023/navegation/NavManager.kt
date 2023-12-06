package com.example.blocknotas2023.navegation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blocknotas2023.CamaraFotografica
import com.example.blocknotas2023.Controles
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes
import com.example.blocknotas2023.EditarMensaje
import com.example.blocknotas2023.GrabandoAudio
import com.example.blocknotas2023.ListaPrincipal
import com.example.blocknotas2023.Notas
import com.example.blocknotas2023.Videos
import com.example.blocknotas2023.viewModel.AudioViewModel
import com.example.blocknotas2023.viewModel.FotosViewModel
import com.example.blocknotas2023.viewModel.MensajesViewModel
import com.example.blocknotas2023.viewModel.VideosViewModel

@Composable
fun Navegacion(
    mensajesViewModel: MensajesViewModel,
    videosViewModel: VideosViewModel,
    fotosViewModel: FotosViewModel,
    audioViewModel: AudioViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "ListaPrincipal") {
        composable("ListaPrincipal") {
            ListaPrincipal(
                navController = navController,
                mensajesViewModel = mensajesViewModel
            )
        }
        composable("Notas") {
            Notas(
                navController = navController,
                viewModel = mensajesViewModel
            )
        }
        composable("Controles") {
            Controles(
                navController = navController,
                notasViewModel = mensajesViewModel
            )
        }
        composable("Videos") {
            Videos(
                navController = navController,
                videosViewModel = videosViewModel
            )
        }
        composable("CamaraFotografica") {
            CamaraFotografica(
                navController = navController,
                fotosViewModel = fotosViewModel
            )
        }
        composable("GrabandoAudio") {
            GrabandoAudio(
                navController = navController,
                AudioViewModel = audioViewModel
            )
        }
        composable("EditarMensaje/{id}") { backStackEntry ->
            val messageId = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            if (messageId != null) {
                val mensajesState by mensajesViewModel.mensajes.collectAsState(initial = emptyList())
                val mensajeSeleccionado: Mensajes? = mensajesState?.firstOrNull { it.id == messageId }
                if (mensajeSeleccionado != null) {
                    EditarMensaje(mensaje = mensajeSeleccionado, mensajesViewModel = mensajesViewModel, navController = navController)
                }
            }
        }
    }
}


