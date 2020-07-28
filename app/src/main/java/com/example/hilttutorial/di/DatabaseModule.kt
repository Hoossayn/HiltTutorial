package com.example.hilttutorial.di

import android.content.Context
import androidx.room.Room
import com.example.hilttutorial.data.db.AppDatabase
import com.example.hilttutorial.utils.SharedPreferenceHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
 
    @Provides
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            appContext,
                AppDatabase::class.java,
            "myDatabase.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun providesSharedPreference(@ApplicationContext context: Context) = SharedPreferenceHelper(context)
}