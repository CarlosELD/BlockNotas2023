package com.example.blocknotas2023.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.blocknotas2023.DataBase.Mnotas.Notas
import com.example.blocknotas2023.DataBase.Mnotas.NotasDataBase
import com.example.blocknotas2023.DataBase.Mnotas.RepositorioNotas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NotasDescriptivasViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: RepositorioNotas
    val allNotas: Flow<List<Notas>>

    init {
        val dao = NotasDataBase.getDatabase(application).notaDao()
        repository = RepositorioNotas(dao)
        allNotas = repository.allNotas
    }

    fun insert(nota: Notas) = viewModelScope.launch(Dispatchers.IO) {
        repository.addNota(nota)
    }

    fun elimina(nota: Notas) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteNota(nota)
    }

    fun actualiza(nota: Notas) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateNota(nota)
    }
}
