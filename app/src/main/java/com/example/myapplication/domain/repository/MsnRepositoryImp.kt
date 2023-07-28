package com.example.myapplication.domain.repository

import com.example.graphqlmsn.Model.apiDataModel.MsnApiModel
import com.example.myapplication.domain.data.MsnApi
import javax.inject.Inject

class MsnRepositoryImp @Inject constructor(
    private val api: MsnApi
) : MsnRepository{
    override suspend fun getMsnApiData(
        site: String,
        start: String,
        end: String,
        offset: Int,
        limit: Int
    ): MsnApiModel? = api.getMsnApiData(site, start, end, offset, limit)

}