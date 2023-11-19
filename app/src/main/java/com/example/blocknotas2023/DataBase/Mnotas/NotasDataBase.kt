package com.example.blocknotas2023.DataBase.Mnotas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notas::class], version = 1, exportSchema = false)
abstract class NotasDataBase : RoomDatabase() {
    abstract fun notaDao(): DaoNotas
    companion object {
        @Volatile
        private var INSTANCE: NotasDataBase? = null

        fun getDatabase(context: Context): NotasDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotasDataBase::class.java,
                    "notas_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}