package com.mili.taejin.data

import com.mili.taejin.data.db.ArticleDao
import com.mili.taejin.data.remote.ApiInterface
import com.mili.taejin.model.Article
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val apiService: ApiInterface,
    private val articleDao: ArticleDao
) {
    suspend fun getArticles(): List<Article> {
        kotlin.runCatching {
            val response = apiService.getTopHeadlines("kr", "3f2cd89f481e4fbc844d11cd800e714a")
            if (response.isSuccessful) {
                response.body()?.let { headline ->
                    articleDao.insertAll(headline.articles)
                }
            }
        }
        return articleDao.getAll()
    }

    suspend fun setReadUrl(url: String){
        articleDao.updateRead(url)
    }
}