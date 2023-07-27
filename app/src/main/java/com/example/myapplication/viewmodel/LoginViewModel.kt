package com.example.myapplication.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Devices
import androidx.lifecycle.ViewModel
import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.example.LoginMutation
import com.example.type.EntitlementDevice
import com.example.type.InitiatePasswordlessSignInput
import kotlinx.coroutines.flow.map

class LoginViewModel: ViewModel() {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("https://api.develop.monumentalsportsnetwork.com/graphql")
        .build()

    val key = mutableStateOf("null")
    val state :State<String> = key

    fun demo(){

        val mutationQuery = apolloClient.mutation(com.example.LoginMutation(
            site = "msndev",
            device = EntitlementDevice.android_phone,
            input = InitiatePasswordlessSignInput(
                email = Optional.present("sjasmeet438@gmail.com"),
                deviceId = Optional.present("1234567890"),
                platform = Optional.present(EntitlementDevice.android_phone),
            )
        )
        ).toFlow().map {
            it.data
          key.value = it.data?.identityInitiateSignOtp?.key.toString()
        }

    }
}