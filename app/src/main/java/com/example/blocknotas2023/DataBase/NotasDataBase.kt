package com.example.blocknotas2023.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Notas::class], version = 1, exportSchema = false)
abstract class NotasDataBase : RoomDatabase() {
    abstract fun notaDao(): DaoNotas
}