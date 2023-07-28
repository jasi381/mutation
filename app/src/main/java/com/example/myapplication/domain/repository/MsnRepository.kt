package com.example.myapplication.domain.repository

import com.example.graphqlmsn.Model.apiDataModel.MsnApiModel
import retrofit2.http.Query

interface MsnRepository {
    suspend fun getMsnApiData(site: String,
                              start: String,
                               end: String,
                             offset: Int,
                              limit: Int): MsnApiModel?
}