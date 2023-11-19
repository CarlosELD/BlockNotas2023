package com.example.blocknotas2023.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.blocknotas2023.DataBase.Mgrabadora.DBAudio
import com.example.blocknotas2023.DataBase.Mgrabadora.DaoGraba
import com.example.blocknotas2023.DataBase.Mgrabadora.graba
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AudioViewModel(application: Application) : AndroidViewModel(application) {

    private val audioDao: DaoGraba
    val allAudios: Flow<List<graba>>

    init {
        val database = DBAudio.getInstance(application.applicationContext)
        audioDao = database.audioDao()
        allAudios = audioDao.getAllAudios()
    }

    fun addAudio(audio: graba) {
        viewModelScope.launch {
            audioDao.addAudio(audio)
        }
    }
}