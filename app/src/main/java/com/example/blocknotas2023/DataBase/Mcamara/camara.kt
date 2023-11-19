package com.example.blocknotas2023.DataBase.Mcamara

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fotos")
data class Foto(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val descripcion: String,
    val ruta: String
)