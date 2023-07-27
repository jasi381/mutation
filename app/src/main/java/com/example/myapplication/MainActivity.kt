package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = viewModel<LoginViewModel>()
                    val key = viewModel.state.value
                  //  val text = if(viewModel.demo()!="null") viewModel.demo() else "null"

                    Column() {
                        Button(onClick= {
                            viewModel.demo()
                            Log.d("Hello", "onCreate: $key")
                        } ) {

                            Text(text = "text")
                        }

                    }
//                    YourComposableFunction()
                }
            }
        }
    }
}

@Composable
fun YourComposableFunction(viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    var logMessage by remember { mutableStateOf("") }

    Column() {
        Button(onClick = {
            logMessage = viewModel.demo().toString()
            Log.d("Hello", "onCreate: $logMessage")
        }) {
            Text(text = "text")
        }
    }
}

