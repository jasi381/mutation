package com.example.myapplication.usecase

import com.example.graphqlmsn.Model.apiDataModel.MsnApiModel
import com.example.graphqlmsn.common.Resource
import com.example.myapplication.common.ErrorHandler
import com.example.myapplication.common.HelperUtil
import com.example.myapplication.domain.repository.MsnRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMsnApiUseCase @Inject constructor(
    private val repository: MsnRepository
) {

    suspend fun execute(
        site: String,
        start: String,
        end: String,
        offset: Int,
        limit: Int
    ): Resource<MsnApiModel> {
        return try {
            val apiData = repository.getMsnApiData(site, start, end, offset, limit)
            Resource.Success(apiData)
        } catch (e: HttpException) {
            val errorCode = HelperUtil.extractCodeFromQueryString(e.response()!!.errorBody().let { it!!.string() } ?: "")
            val errorMessage = ErrorHandler.parseRetrofitAPIError(errorCode)
           if (errorMessage!!.message == null) {
               Resource.Error("UnExpected Error")
           }else{
               Resource.Error(errorMessage.message)

           }
        }
        catch (e: IOException){
            Resource.Error("No internet")
        }
    }
}

