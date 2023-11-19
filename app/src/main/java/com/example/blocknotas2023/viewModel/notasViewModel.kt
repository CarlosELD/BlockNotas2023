package com.example.blocknotas2023.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.blocknotas2023.DataBase.Mnotas.DaoNotas
import com.example.blocknotas2023.DataBase.Mnotas.Notas
import com.example.blocknotas2023.DataBase.Mnotas.NotasDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NotasViewModel(application: Application) : AndroidViewModel(application) {
    private val db: NotasDataBase = Room.databaseBuilder(
        application,
        NotasDataBase::class.java, "notas-db"
    ).build()

    private val notaDao: DaoNotas = db.notaDao()

    val allNotes: Flow<List<Notas>> = notaDao.getAll()

    fun insert(nota: Notas) {
        viewModelScope.launch(Dispatchers.IO) {
            notaDao.insert(nota)
        }
    }

    val allNotas: Flow<List<Notas>> = notaDao.getAll()
    fun update(note: Notas) {
        viewModelScope.launch(Dispatchers.IO) {
            notaDao.update(note)
        }
    }

    fun delete(note: Notas) {
        viewModelScope.launch(Dispatchers.IO) {
            notaDao.delete(note)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            notaDao.deleteAll()
        }
    }

    suspend fun getNoteById(noteId: Int): Notas? {
        return notaDao.getNoteById(noteId)
    }
}




