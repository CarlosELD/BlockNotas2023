package com.example.blocknotas2023.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.blocknotas2023.DataBase.Mcamara.DBFotos
import com.example.blocknotas2023.DataBase.Mcamara.DaoFotos
import com.example.blocknotas2023.DataBase.Mcamara.Foto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FotosViewModel(application: Application) : AndroidViewModel(application) {

    private val fotosDao: DaoFotos
    val allFotos: Flow<List<Foto>>

    init {
        val database = DBFotos.getInstance(application.applicationContext)
        fotosDao = database.fotosDao()
        allFotos = fotosDao.getAllFotos()
    }

    fun addFoto(foto: Foto) {
        viewModelScope.launch {
            fotosDao.addFoto(foto)
        }
    }
}