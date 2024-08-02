package com.mili.taejin.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mili.taejin.model.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(articles: List<Article>)

    @Query("SELECT * FROM articles")
    suspend fun getAll(): List<Article>

    @Query("UPDATE articles SET read = 1 WHERE url = :url")
    suspend fun updateRead(url: String)
}