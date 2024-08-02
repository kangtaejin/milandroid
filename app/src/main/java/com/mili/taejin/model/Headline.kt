package com.mili.taejin.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Headline(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

@Entity(tableName = "articles")
data class Article(
    val title: String,
    val content: String?,
    @PrimaryKey val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val read: Int
)
