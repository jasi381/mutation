package com.example.myapplication.presentation

import com.example.graphqlmsn.Model.apiDataModel.MsnApiModel

data class ApiDataState(
    val isLoading: Boolean = false,
    val msnapi: MsnApiModel? = null,
    val error: String = ""
    )