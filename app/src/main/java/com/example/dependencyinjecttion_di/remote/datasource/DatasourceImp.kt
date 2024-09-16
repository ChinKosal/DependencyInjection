package com.example.dependencyinjecttion_di.remote.datasource

import com.example.dependencyinjecttion_di.data.article.ArticleResponse
import com.example.dependencyinjecttion_di.remote.repository.ArticleService
import retrofit2.Response
import javax.inject.Inject

class DatasourceImp @Inject constructor(private val articleService: ArticleService) : Datasource {
    override suspend fun getArticles(): Response<ArticleResponse> {
        return articleService.getAllArticles()
    }
}