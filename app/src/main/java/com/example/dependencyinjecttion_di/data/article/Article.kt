package com.example.dependencyinjecttion_di.data.article

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("id") var id: Int ? = null,
    @SerializedName("title") var title: String ? = null,
    @SerializedName("content") var content: String ? = null,
    @SerializedName("imageUrl") var imageUrl: String ? = null,
    @SerializedName("author") var author: String ? = null,
    @SerializedName("publishedDate") var publishedDate: String ? = null,
    @SerializedName("views") var views: Int ? = null,
    @SerializedName("isPublished") var isPublished: Boolean  ? = null
)