package com.example.blocknotas2023.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blocknotas2023.CamaraFotografica
import com.example.blocknotas2023.Controles
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes
import com.example.blocknotas2023.GrabandoAudio
import com.example.blocknotas2023.ListaPrincipal
import com.example.blocknotas2023.Notas
import com.example.blocknotas2023.NotasDescriptivas
import com.example.blocknotas2023.Videos
import com.example.blocknotas2023.viewModel.AudioViewModel
import com.example.blocknotas2023.viewModel.FotosViewModel
import com.example.blocknotas2023.viewModel.MensajesViewModel
import com.example.blocknotas2023.viewModel.NotasDescriptivasViewModel
import com.example.blocknotas2023.viewModel.VideosViewModel

@Composable
fun Navegacion(
    mensajesViewModel: MensajesViewModel,
    videosViewModel: VideosViewModel,
    notasDescriptivasViewModel: NotasDescriptivasViewModel,
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
        composable("NotasDescriptivas") {
            NotasDescriptivas(
                "Título de la nota descriptiva",
                "Contenido de la nota descriptiva",
                "Fecha de la nota descriptiva",
                "Hora de la nota descriptiva",
                navController = navController,
                NotasDescriptivasViewModel = notasDescriptivasViewModel
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
        composable("EditarMensaje/{id}") {backStackEntry ->
            val messageId = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            if (messageId != null) {
                val mensajeSeleccionado: Mensajes? = mensajesViewModel.mensajes.firstOrNull { it.id == messageId }
                navController.navigate("EditarMensaje/${mensajeSeleccionado?.id}") {
                    launchSingleTop = true
                }
            } else {
                navController.navigate("Error") {
                    launchSingleTop = true
                }
            }
        }

    }
}


