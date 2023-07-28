package com.example.myapplication

import com.example.myapplication.errorTypes.ErrorValues

object ErrorHandler {


    fun parseGraphQLError(apolloError: String?): Throwable? {

        when (apolloError) {
            "CROSS_COUNTRY_PHONE" -> {
                return Throwable(ErrorValues.CROSS_COUNTRY_PHONE)
            }

            "DEVICE_LIMIT_EXCEEDED" -> {
                return Throwable(ErrorValues.DEVICE_LIMIT_EXCEEDED)
            }

            "EMAIL_ALREADY_LINKED" -> {
                return Throwable(ErrorValues.EMAIL_ALREADY_LINKED)
            }
            "EMAIL_NOT_EXIST" -> {
                return Throwable(ErrorValues.EMAIL_NOT_EXIST)
            }
            "EMAIL_NOT_VALID" -> {
                return Throwable(ErrorValues.EMAIL_NOT_VALID)
            }
            "EMAIL_NOT_REGISTERED" -> {
                return Throwable(ErrorValues.EMAIL_NOT_REGISTERED)
            }
            "EMAIL_OR_PASSWORD_INCORRECT" -> {
                return Throwable(ErrorValues.EMAIL_OR_PASSWORD_INCORRECT)
            }
            "EMAIL_VERIFICATION_FAILED" -> {
                return Throwable(ErrorValues.EMAIL_VERIFICATION_FAILED)
            }
            "INVALID_REQUEST_PARAMS" -> {
                return Throwable(ErrorValues.INVALID_REQUEST_PARAMS)
            }
            "NAME_NOT_VALID" -> {
                return Throwable(ErrorValues.NAME_NOT_VALID)
            }
            "OTP_MISMATCH" -> {
                return Throwable(ErrorValues.OTP_MISMATCH)
            }
            "OTP_SENT_FAILED" -> {
                return Throwable(ErrorValues.OTP_SENT_FAILED)
            }
            "PASSWORD_NOT_VALID" -> {
                return Throwable(ErrorValues.PASSWORD_NOT_VALID)
            }
            "PHONE_ALREADY_LINKED" -> {
                return Throwable(ErrorValues.PHONE_ALREADY_LINKED)
            }
            "PHONE_NOT_LINKED" -> {
                return Throwable(ErrorValues.PHONE_NOT_LINKED)
            }
            "PHONE_NOT_VALID" -> {
                return Throwable(ErrorValues.PHONE_NOT_VALID)
            }
            "VERIFY_OTP_FAILED" -> {
                return Throwable(ErrorValues.VERIFY_OTP_FAILED)
            }
            "UNVERIFIED_PHONE" -> {
                return Throwable(ErrorValues.UNVERIFIED_PHONE)
            }
            "MAX_NUMBER_OF_OTP_EXCEEDED" -> {
                return Throwable(ErrorValues.MAX_NUMBER_OF_OTP_EXCEEDED)
            }
            "OTP_NOT_VALID" -> {
                return Throwable(ErrorValues.OTP_NOT_VALID)
            }
            else -> {
                return null
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