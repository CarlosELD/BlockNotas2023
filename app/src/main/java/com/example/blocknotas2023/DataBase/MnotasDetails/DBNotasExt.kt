package com.example.blocknotas2023.DataBase.MnotasDetails

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NotasD::class], version = 1, exportSchema = false)
abstract class DBNotasExt : RoomDatabase() {
    abstract fun notaDao(): DaoND
    companion object {
        @Volatile
        private var INSTANCE: DBNotasExt? = null

        fun getDatabase(context: Context): DBNotasExt {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBNotasExt::class.java,
                    "notas_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}