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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

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
                    YourComposableFunction2()
                }
            }
        }
    }
}



@Composable
fun YourComposableFunction2(viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    var logMessage by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Column {
        Button(onClick = {

            coroutineScope.launch {
                logMessage = viewModel.demo()
                Log.d("Hello", "onCreate: $logMessage")
            }
        }) {
            Text(text = "text")
        }
    }
}

