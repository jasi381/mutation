package com.example.myapplication.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun ApiScreen(
    msnapistate: ApiDataState,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (msnapistate.msnapi != null) {
            Column() {
                Text(text = msnapistate.msnapi.items.size.toString(), color = Color.Black)
                LazyColumn() {
                    items(msnapistate.msnapi!!.items) {
                        Text(text = it.title, color = Color.Black)
                    }
                }
            }
        }
        if (msnapistate.isLoading){
            LinearProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        if (msnapistate.error.isNotBlank()){
            Text(
                text = msnapistate.error,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
    }

}