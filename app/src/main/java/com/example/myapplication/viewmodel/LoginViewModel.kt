package com.example.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.example.type.EntitlementDevice
import com.example.type.InitiatePasswordlessSignInput
import kotlinx.coroutines.flow.singleOrNull


class LoginViewModel : ViewModel() {
    private val apolloClient = ApolloClient.Builder()
        .serverUrl("https://api.develop.monumentalsportsnetwork.com/graphql")
        .build()

    private val key = mutableStateOf("null")

    suspend fun demo(): String {
        val mutationQuery = apolloClient.mutation(
            com.example.LoginMutation(
                site = "msndev",
                device = EntitlementDevice.android_phone,
                input = InitiatePasswordlessSignInput(
                    email = Optional.present("sjasmeet43"),
                    deviceId = Optional.present("1234567890"),
                    platform = Optional.present(EntitlementDevice.android_phone),
                )
            )
        ).toFlow()
        val response = mutationQuery.singleOrNull()
        key.value = response?.data?.identityInitiateSignOtp?.key.toString()

        return key.value
    }
}
