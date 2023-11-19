package com.example.blocknotas2023.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.blocknotas2023.DataBase.Mvideos.videoDataBase
import com.example.blocknotas2023.DataBase.Mvideos.DaoVideo
import com.example.blocknotas2023.DataBase.Mvideos.Video
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class VideosViewModel(application: Application) : AndroidViewModel(application) {
    private val videoDao: DaoVideo

    init {
        val database = videoDataBase.getInstance(application)
        videoDao = database.videoDao()
    }

    fun insertV(title: String, description: String, filePath: String) {
        viewModelScope.launch {
            val video = Video(title = title, description = description, filePath = filePath)
            videoDao.insertV(video)
        }
    }

    fun updateV(video: Video) {
        viewModelScope.launch {
            videoDao.updateV(video)
        }
    }

    fun deleteV(video: Video) {
        viewModelScope.launch {
            videoDao.deleteV(video)
        }
    }

    fun getAllV(): Flow<List<Video>> {
        return videoDao.getAll()
    }

    // Puedes agregar más funciones según tus necesidades, como obtener un video por su ID, etc.
}
