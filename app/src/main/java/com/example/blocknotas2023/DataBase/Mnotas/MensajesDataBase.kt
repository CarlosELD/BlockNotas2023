package com.example.blocknotas2023.DataBase.Mnotas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Mensajes::class], version = 1, exportSchema = false)
abstract class MensajesDataBase : RoomDatabase() {
    abstract fun msgDao(): DaoMensajes

    companion object {
        @Volatile
        private var INSTANCE: MensajesDataBase? = null
        fun getDatabase(context: Context): MensajesDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MensajesDataBase::class.java,
                    "msg_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}