package com.example.dependencyinjecttion_di.remote.repository

import com.example.dependencyinjecttion_di.data.article.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET

interface ArticleService {
    @GET("articles")
    suspend fun getAllArticles(): Response<ArticleResponse>
}

