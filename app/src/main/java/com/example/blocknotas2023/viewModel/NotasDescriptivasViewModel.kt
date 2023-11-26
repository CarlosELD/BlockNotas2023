package com.example.blocknotas2023.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes
import com.example.blocknotas2023.DataBase.Mnotas.MensajesDataBase
import com.example.blocknotas2023.DataBase.Mnotas.RepositorioMsg
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NotasDescriptivasViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: RepositorioMsg
    val allNotas: Flow<List<Mensajes>>

    init {
        val dao = MensajesDataBase.getDatabase(application).msgDao()
        repository = RepositorioMsg(dao)
        allNotas = repository.allNota
    }

    fun insert(nota: Mensajes) = viewModelScope.launch(Dispatchers.IO) {
        repository.addNota(nota)
    }

    fun elimina(nota: Mensajes) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteNota(nota)
    }

    fun actualiza(nota: Mensajes) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateNota(nota)
    }
}
