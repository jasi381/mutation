package com.example.myapplication.domain.data

import com.example.graphqlmsn.Model.apiDataModel.MsnApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MsnApi {
    @GET("/v3/content/game/schedule")
    suspend fun getMsnApiData(
        @Query("site") site: String,
        @Query("start") start: String,
        @Query("end") end: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): MsnApiModel?
}