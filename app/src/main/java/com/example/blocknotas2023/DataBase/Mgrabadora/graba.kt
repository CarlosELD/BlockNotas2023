package com.example.blocknotas2023.DataBase.Mgrabadora

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "audios")
data class graba(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val descripcion: String
)