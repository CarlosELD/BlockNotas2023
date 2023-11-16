package com.example.blocknotas2023.DataBase

import android.provider.SyncStateContract.Constants
import androidx.compose.ui.unit.Constraints
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notas")
data class Notas(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    @ColumnInfo(name="title")
    val title: String,
    @ColumnInfo(name="contenido")
    val content: String
)
