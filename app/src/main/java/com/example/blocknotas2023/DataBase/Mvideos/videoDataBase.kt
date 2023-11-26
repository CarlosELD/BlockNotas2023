package com.example.blocknotas2023.DataBase.Mvideos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Video::class], version = 1)
abstract class videoDataBase : RoomDatabase() {
    abstract fun videoDao(): DaoVideo
    companion object {
        private const val DATABASE_NAME = "videos_database"

        @Volatile
        private var instance: videoDataBase? = null

        fun getInstance(context: Context): videoDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): videoDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                videoDataBase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}