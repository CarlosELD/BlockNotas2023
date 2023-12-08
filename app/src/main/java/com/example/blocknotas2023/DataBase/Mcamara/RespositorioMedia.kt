package com.example.blocknotas2023.DataBase.Mcamara

import kotlinx.coroutines.flow.Flow

class MediaRepository(private val mediaDao: MediaDao) {

    suspend fun insertMediaItem(mediaItem: MediaItem) {
        mediaDao.insertMediaItem(mediaItem)
    }

    suspend fun deleteMediaItem(mediaItem: MediaItem) {
        mediaDao.deleteMediaItem(mediaItem)
    }

    fun searchMediaItems(searchTerm: String): Flow<List<MediaItem>> {
        return mediaDao.searchMediaItems(searchTerm)
    }
}