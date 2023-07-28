package com.example.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.exception.ApolloException
import com.example.myapplication.ErrorHandler
import com.example.myapplication.helpers.HelperFunctions
import com.example.type.EntitlementDevice
import com.example.type.InitiatePasswordlessSignInput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.singleOrNull
import javax.inject.Inject


@HiltViewModel
class LoginViewModel
@Inject constructor(
    private val apolloClient: ApolloClient
) : ViewModel() {


    private val key = mutableStateOf<String?>(null)

    suspend fun graphQlErrorHandler(): String {

        try {
            val mutationQuery = apolloClient.mutation(
                com.example.LoginMutation(
                    site = "msndev",
                    device = EntitlementDevice.android_phone,
                    input = InitiatePasswordlessSignInput(
                        email = Optional.present(".com"),
                        deviceId = Optional.present("1234567890"),
                        platform = Optional.present(EntitlementDevice.android_phone),
                    )
                )
            ).toFlow()
            val response = mutationQuery.singleOrNull()
            key.value = response?.dataAssertNoErrors.toString()

            return key.value?:"Key is null"
        }catch (e: ApolloException) {
            //value to extract error code from message
            val errorCode = HelperFunctions.extractErrorCodeFromMessage(e.message ?: "")
            //value to extract error message from error code
            val errorMessage = ErrorHandler.parseGraphQLError(errorCode)
            if (errorMessage == null) {
                key.value = e.message.toString()
                return "Something went wrong"
            }
            return errorMessage.message.toString()

        }

    }

}


