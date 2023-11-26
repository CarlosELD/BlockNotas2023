package com.example.blocknotas2023.DataBase.Mnotas

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mensajes")
data class Mensajes(
    @PrimaryKey
    val id: Int,
    val title: String,
    val contenido: String
)