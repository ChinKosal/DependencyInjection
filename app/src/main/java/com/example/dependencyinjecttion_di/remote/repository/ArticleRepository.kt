package com.example.dependencyinjecttion_di.remote.repository

import com.example.dependencyinjecttion_di.data.article.ArticleResponse
import retrofit2.Response
interface ArticleRepository {
    suspend fun getArticles(): Response<ArticleResponse>
}

