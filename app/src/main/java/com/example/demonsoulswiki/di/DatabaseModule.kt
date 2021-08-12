package com.example.demonsoulswiki.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.demonsoulswiki.database.AppDatabase
import com.example.demonsoulswiki.database.AppDatabase.Companion.DATABASE_NAME
import com.example.demonsoulswiki.weapon.WeaponDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, DATABASE_NAME).build()
    }

    @Provides
    fun provideWeaponDao(database: AppDatabase): WeaponDao {
        return database.weaponDao()
    }
}