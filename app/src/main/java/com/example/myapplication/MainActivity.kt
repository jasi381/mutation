package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.presentation.ApiScreen
import com.example.myapplication.presentation.MsnApiViewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val viewModel = hiltViewModel<MsnApiViewModel>()
                viewModel.getMsnApiData( "", "1688223896", "1690815896", 0,100)

                val msnapistate by viewModel.msnstate.collectAsState()

                ApiScreen(msnapistate = msnapistate )
            }
        }
    }
}



