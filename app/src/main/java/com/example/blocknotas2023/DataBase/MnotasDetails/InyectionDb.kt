package com.example.blocknotas2023.DataBase.MnotasDetails

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
    fun providesNotasDescriptivasDao(notasDescriptivasDatabase: DBNotasExt): DaoND {
        return notasDescriptivasDatabase.notaDao()
    }

    @Singleton
    @Provides
    fun providesNotasDescriptivasDatabase(@ApplicationContext context: Context): DBNotasExt {
        return Room.databaseBuilder(
            context,
            DBNotasExt::class.java,
            "notas_descriptivas"
        ).fallbackToDestructiveMigration().build()
    }
}


