package com.example.graphqlmsn.Model.apiDataModel

data class HomeTeam(
    val _id: String,
    val currentSeason: String,
    val gist: GistXXX,
    val id: String,
    val owner: Boolean,
    val shortName: String,
    val title: String
)