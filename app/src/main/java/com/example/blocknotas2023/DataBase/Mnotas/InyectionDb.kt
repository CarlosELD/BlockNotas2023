package com.example.blocknotas2023.DataBase.Mnotas

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InyectionDb {
    @Singleton
    @Provides
    fun providesDaoNotas(notasDB: MensajesDataBase): DaoMensajes {
        return notasDB.msgDao()
    }

    @Singleton
    @Provides
    fun proviesNotasDB(@ApplicationContext context: Context): MensajesDataBase {

        return Room.databaseBuilder(
            context,
            MensajesDataBase::class.java,
            "Notas"
        ).fallbackToDestructiveMigration().build()
    }
}


