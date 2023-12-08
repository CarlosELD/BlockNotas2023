package com.example.blocknotas2023.DataBase.Mcamara

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MediaItem(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val uri: String,
    val type: MediaType
)