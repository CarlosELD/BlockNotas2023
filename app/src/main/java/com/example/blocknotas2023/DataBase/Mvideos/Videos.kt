package com.example.blocknotas2023.DataBase.Mvideos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "videos")
data class Video(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val filePath: String
)