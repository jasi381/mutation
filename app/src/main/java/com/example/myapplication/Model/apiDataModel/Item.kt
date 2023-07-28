package com.example.graphqlmsn.Model.apiDataModel

data class Item(
    val author: Author,
    val awayTeam: AwayTeam,
    val broadcaster: String,
    val categories: List<Any>,
    val contentType: String,
    val currentState: String,
    val gist: GistX,
    val highlights: List<Highlight>,
    val homeTeam: HomeTeam,
    val id: String,
    val league: League,
    val livestreams: List<Livestream>,
    val metadata: List<Metadata>,
    val preview: Preview,
    val publishDate: Int,
    val related: List<Related>,
    val schedules: List<Schedule>,
    val score: Score,
    val sportsRadar: SportsRadar,
    val states: States,
    val tags: List<Tag>,
    val ticketMasterId: String,
    val ticketUrl: String,
    val title: String,
    val type: Any
)