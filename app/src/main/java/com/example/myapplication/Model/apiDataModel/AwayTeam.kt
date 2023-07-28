package com.example.graphqlmsn.Model.apiDataModel

data class AwayTeam(
    val _id: String,
    val currentSeason: String,
    val gist: Gist,
    val id: String,
    val owner: Boolean,
    val records: Records,
    val shortName: String,
    val title: String
)