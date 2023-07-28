package com.example.graphqlmsn.Model.apiDataModel

data class GistXX(
    val categories: Any,
    val contentType: String,
    val description: String,
    val featuredTag: FeaturedTag,
    val id: String,
    val imageGist: ImageGistXX,
    val languageCode: String,
    val permalink: String,
    val scheduleEndDate: Any,
    val scheduleStartDate: Any,
    val site: String,
    val timezone: String,
    val title: String
)