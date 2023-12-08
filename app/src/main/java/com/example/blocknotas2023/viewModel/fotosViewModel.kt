package com.example.blocknotas2023.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blocknotas2023.DataBase.Mcamara.MediaItem
import com.example.blocknotas2023.DataBase.Mcamara.MediaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MediaViewModel(private val repository: MediaRepository) : ViewModel() {
    private val _mediaItems = MutableStateFlow<List<MediaItem>>(emptyList())
    val mediaItems: StateFlow<List<MediaItem>> get() = _mediaItems

    private var currentSearchTerm = ""

    fun insertMediaItem(mediaItem: MediaItem) {
        viewModelScope.launch {
            repository.insertMediaItem(mediaItem)
        }
    }

    fun deleteMediaItem(mediaItem: MediaItem) {
        viewModelScope.launch {
            repository.deleteMediaItem(mediaItem)
        }
    }

    fun searchMediaItems(searchTerm: String) {
        viewModelScope.launch {
            repository.searchMediaItems(searchTerm).collect {
                _mediaItems.value = it
            }
        }
    }

    fun refreshList() {
        searchMediaItems(currentSearchTerm)
    }
}
