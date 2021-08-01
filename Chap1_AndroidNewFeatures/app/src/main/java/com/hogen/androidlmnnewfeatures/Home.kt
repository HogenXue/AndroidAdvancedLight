package com.hogen.androidlmnnewfeatures.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hogen.androidlmnnewfeatures.ui.theme.AndroidLMNNewFeaturesTheme


@Composable
fun MyApp(){
    Scaffold(
        content = { HomeContent()}
    )
}

@Composable
fun HomeContent(){
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp,vertical = 8.dp)
    ) {

    }
}