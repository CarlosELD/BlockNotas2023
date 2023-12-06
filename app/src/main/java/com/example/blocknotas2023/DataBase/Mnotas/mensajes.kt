package com.example.blocknotas2023.DataBase.Mnotas

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mensajes")
data class Mensajes(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val contenido: String
)