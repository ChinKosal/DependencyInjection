package com.example.dependencyinjecttion_di.remote.datasource

import com.example.dependencyinjecttion_di.data.article.ArticleResponse
import retrofit2.Response
interface Datasource {
    suspend fun getArticles(): Response<ArticleResponse>
}

