package com.example.graphqlmsn.Model.apiDataModel

data class GistX(
    val categories: Any,
    val contentType: String,
    val description: String,
    val featuredTag: FeaturedTag,
    val id: String,
    val languageCode: String,
    val permalink: String,
    val primaryCategory: PrimaryCategoryX,
    val scheduleEndDate: Any,
    val scheduleStartDate: Any,
    val site: String,
    val timezone: Any,
    val title: String
)