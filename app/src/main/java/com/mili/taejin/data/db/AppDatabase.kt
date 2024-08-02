package com.mili.taejin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mili.taejin.model.Article

@Database(entities = [Article::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}