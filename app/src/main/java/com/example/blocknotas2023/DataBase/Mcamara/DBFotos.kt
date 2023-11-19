package com.example.blocknotas2023.DataBase.Mcamara

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Foto::class], version = 1)
abstract class DBFotos : RoomDatabase() {
    abstract fun fotosDao(): DaoFotos

    companion object {
        @Volatile
        private var INSTANCE: DBFotos? = null

        fun getInstance(context: Context): DBFotos {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBFotos::class.java,
                    "fotos_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}