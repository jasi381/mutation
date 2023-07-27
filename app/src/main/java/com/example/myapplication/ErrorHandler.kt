package com.example.myapplication

import com.apollographql.apollo3.exception.ApolloException
import com.example.myapplication.errorTypes.ErrorTypes

object ErrorHandler {


    fun parseGraphQLError(apolloError: String?): Throwable {

      when(apolloError){
          ErrorTypes.EMAIL_NOT_VALID -> {
              return Throwable("Cross Country Phone")
          }
          else -> {
              return Throwable("Error Message")
          }
      }


    }

//    fun parseRetrofitAPIError(): Throwable {
//
//        // ErrorBody Retrofit
//
//        val error : Throwable = Throwable("Error Message")
//        error.message
//
//
//    }


}