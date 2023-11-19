package com.example.blocknotas2023.DataBase.Mvideos

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
    fun providesDaoNotas(notasDB: videoDataBase): DaoVideo {
        return notasDB.videoDao()
    }
    @Singleton
    @Provides
    fun proviesNotasDB(@ApplicationContext context: Context): videoDataBase {
        return Room.databaseBuilder(context,videoDataBase::class.java,"Notas"
        ).fallbackToDestructiveMigration().build()
    }
}


