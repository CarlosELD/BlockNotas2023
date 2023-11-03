package com.example.blocknotas2023.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Notas::class], version = 1)
abstract class NDB : RoomDatabase() {
    abstract fun noteDao(): DBNotas
}
