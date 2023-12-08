package com.example.blocknotas2023.navegation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blocknotas2023.AudioRecorderButton
import com.example.blocknotas2023.Controles
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes
import com.example.blocknotas2023.EditarMensaje
import com.example.blocknotas2023.ListaPrincipal
import com.example.blocknotas2023.Notas
import com.example.blocknotas2023.TomarFoto
import com.example.blocknotas2023.viewModel.AudioViewModel
import com.example.blocknotas2023.viewModel.MediaViewModel
import com.example.blocknotas2023.viewModel.MensajesViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navegacion(
    mensajesViewModel: MensajesViewModel,
    fotosViewModel: MediaViewModel,
    audioViewModel: AudioViewModel
) {
    val navController = rememberNavController()
    val context = LocalContext.current
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
        composable("TomarFoto") {
            TomarFoto(
                navController = navController,
                mediaViewModel = fotosViewModel
            )
        }
        composable("GrabandoAudio") {
            AudioRecorderButton(navController = navController)
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





