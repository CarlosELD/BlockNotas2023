package com.example.blocknotas2023.DataBase.Mgrabadora

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [graba::class], version = 1)
abstract class DBAudio : RoomDatabase() {
    abstract fun audioDao(): DaoGraba

    companion object {
        @Volatile
        private var INSTANCE: DBAudio? = null

        fun getInstance(context: Context): DBAudio {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBAudio::class.java,
                    "audio_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}