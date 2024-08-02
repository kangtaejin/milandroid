package com.mili.taejin.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mili.taejin.data.ArticleRepository
import com.mili.taejin.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ArticleRepository) : ViewModel()  {

    private val mArticlesData = MutableLiveData<List<Article>?>()
    val articles = mArticlesData

    fun getTopHeadlines(){
        viewModelScope.launch {
            mArticlesData.postValue(repository.getArticles())
        }
    }

    fun setReadUrl(url: String){
        viewModelScope.launch {
            repository.setReadUrl(url)
            mArticlesData.postValue(
                mArticlesData.value?.map { article ->
                    if (article.url == url) {
                        article.copy(read = 1)
                    } else {
                        article
                    }
                }
            )
        }
    }
}