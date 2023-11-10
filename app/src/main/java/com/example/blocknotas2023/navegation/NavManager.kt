package com.example.blocknotas2023.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blocknotas2023.CamaraFotografica
import com.example.blocknotas2023.Controles
import com.example.blocknotas2023.GrabandoAudio
import com.example.blocknotas2023.ListaPrincipal
import com.example.blocknotas2023.Notas
import com.example.blocknotas2023.NotasDescriptivas
import com.example.blocknotas2023.Videos

@Composable
fun Navegacion(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "ListaPrincipal") {
        composable("ListaPrincipal") { ListaPrincipal(navController) }
        composable("Notas") { Notas(navController) }
        composable("Controles") { Controles(navController) }
        composable("Videos") { Videos(navController) }
        composable("NotasDescriptivas") { NotasDescriptivas(navController) }
        composable("CamaraFotografica") { CamaraFotografica(navController) }
        composable("GrabandoAudio") { GrabandoAudio(navController) }
    }
}