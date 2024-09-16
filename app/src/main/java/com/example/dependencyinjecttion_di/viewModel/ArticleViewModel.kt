package com.example.dependencyinjecttion_di.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjecttion_di.data.article.Article
import com.example.dependencyinjecttion_di.remote.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val articleRepo: ArticleRepository
) : ViewModel() {
    private val _articles: MutableLiveData<List<Article>> = MutableLiveData(emptyList())
    val articles: LiveData<List<Article>> get() = _articles
    fun getAllArticles() {
        viewModelScope.launch {
            try {
                val response = articleRepo.getArticles()
                if (response.isSuccessful) {
                    _articles.postValue(response.body()?.payload ?: emptyList())
                } else {
                    Log.e(">>", "Error fetching articles: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e(">>", "Error fetching articles", e)
            }
        }
    }
}


