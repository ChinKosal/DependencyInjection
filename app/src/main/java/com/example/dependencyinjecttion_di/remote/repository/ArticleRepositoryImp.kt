package com.example.dependencyinjecttion_di.remote.repository

import com.example.dependencyinjecttion_di.data.article.ArticleResponse
import com.example.dependencyinjecttion_di.remote.datasource.Datasource
import retrofit2.Response
import javax.inject.Inject

class ArticleRepositoryImp @Inject constructor(
    private val datasource: Datasource
) : ArticleRepository {
    override suspend fun getArticles(): Response<ArticleResponse> {
        return datasource.getArticles()
    }
}


