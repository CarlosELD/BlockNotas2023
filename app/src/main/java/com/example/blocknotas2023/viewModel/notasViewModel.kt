package com.example.blocknotas2023.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blocknotas2023.DataBase.Notas
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class notasViewModel : ViewModel() {
    var notas: List<Notas> by mutableStateOf(listOf())
        private set

    init {
        viewModelScope.launch {
            delay(5000)
            notas = listOf(
                Notas(0, "Título 1", "Contenido 1"),
                Notas(1, "Título 2", "Contenido 2")
            )
        }
    }
}




