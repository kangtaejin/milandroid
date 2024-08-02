package com.mili.taejin.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mili.taejin.data.db.AppDatabase
import com.mili.taejin.data.db.ArticleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext.applicationContext, AppDatabase::class.java, "kangtae.sqlite"
        ).fallbackToDestructiveMigration().addCallback(object : RoomDatabase.Callback() {}).build()
    }

    @Singleton
    @Provides
    fun provideArticleDao(db: AppDatabase): ArticleDao {
        return db.articleDao()
    }
}