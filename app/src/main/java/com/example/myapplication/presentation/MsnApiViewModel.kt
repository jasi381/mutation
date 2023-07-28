package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqlmsn.common.Resource
import com.example.myapplication.usecase.GetMsnApiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MsnApiViewModel @Inject constructor(
    private val getMsnApiUseCase: GetMsnApiUseCase
) : ViewModel() {
    private val _msnstate = MutableStateFlow(ApiDataState())
    val msnstate = _msnstate.asStateFlow()

    fun getMsnApiData(
        site: String,
        start: String,
        end: String,
        offset: Int,
        limit: Int
    ) {
        viewModelScope.launch {
            val result = getMsnApiUseCase.execute(site, start, end, offset, limit)
            when (result) {
                is Resource.Loading -> {
                    _msnstate.value = ApiDataState(isLoading = false)
                }
                is Resource.Success -> {
                    _msnstate.value = ApiDataState(msnapi = result.data, isLoading = false)
                }
                is Resource.Error -> {
                    _msnstate.value = ApiDataState(error = result.message ?: "error")
                }
            }
        }
    }
}

