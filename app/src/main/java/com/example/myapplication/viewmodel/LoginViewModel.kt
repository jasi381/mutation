package com.example.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.exception.ApolloException
import com.example.myapplication.ErrorHandler
import com.example.type.EntitlementDevice
import com.example.type.InitiatePasswordlessSignInput
import kotlinx.coroutines.flow.singleOrNull


class LoginViewModel : ViewModel() {
    private val apolloClient = ApolloClient.Builder()
        .serverUrl("https://api.develop.monumentalsportsnetwork.com/graphql")
        .build()

    private val key = mutableStateOf<String?>(null)

    suspend fun demo(): String {

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
            val errorCode = extractErrorCodeFromMessage(e.message ?: "")
            val errorMessage = ErrorHandler.parseGraphQLError(errorCode)
            return (errorMessage?:"Error code is null").toString()

        }

        catch (e:Exception){
            key.value = e.message.toString()
            return  "Other Exception occurred: ${e.message}"
        }
    }

    private fun extractErrorCodeFromMessage(message: String): String? {
        val regex = """code=(\w+)""".toRegex()
        val matchResult = regex.find(message)
        return matchResult?.groupValues?.get(1)
    }
}


