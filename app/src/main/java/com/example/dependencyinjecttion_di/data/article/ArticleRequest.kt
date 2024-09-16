package com.example.dependencyinjecttion_di.data.article

import androidx.room.PrimaryKey

data class ArticleRequest(
    @PrimaryKey(autoGenerate = true)
    var title: String ? = null,
    var content: String ? = null,
    var imageUrl: String ? = null,
    var author: String ? = null,
    var publishedDate: String ? = null,
    var views: Int ? = null,
    var isPublished: Boolean ? = null
)