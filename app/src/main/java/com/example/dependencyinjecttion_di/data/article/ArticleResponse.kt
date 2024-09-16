package com.example.dependencyinjecttion_di.data.article

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @SerializedName("message") var message: String ? = null,
    @SerializedName("payload") var payload: List<Article>? = null,
    @SerializedName("status") var status: String ? = null,
)