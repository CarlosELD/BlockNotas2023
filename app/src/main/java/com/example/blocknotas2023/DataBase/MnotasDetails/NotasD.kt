package com.example.blocknotas2023.DataBase.MnotasDetails

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notas_descriptivas")
data class NotasD(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val fecha: String,
    val hora: String
)