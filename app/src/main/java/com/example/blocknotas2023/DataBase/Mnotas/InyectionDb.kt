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
    fun providesDaoNotas(notasDB: NotasDataBase): DaoNotas {
        return notasDB.notaDao()
    }

    @Singleton
    @Provides
    fun proviesNotasDB(@ApplicationContext context: Context): NotasDataBase {

        return Room.databaseBuilder(
            context,
            NotasDataBase::class.java,
            "Notas"
        ).fallbackToDestructiveMigration().build()
    }
}


