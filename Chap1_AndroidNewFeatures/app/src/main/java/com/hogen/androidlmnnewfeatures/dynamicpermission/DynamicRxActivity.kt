package com.hogen.androidlmnnewfeatures.dynamicpermission

import android.Manifest
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.hogen.androidlmnnewfeatures.ui.theme.AndroidLMNNewFeaturesTheme

/**
 * @author Hogen.Xue
 * @version 1.0.0
 * @time 2021/8/2 15:13
 * @brief
 */
class DynamicRxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidLMNNewFeaturesTheme {

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen()
                }
            }
        }
    }
}


private fun requestPermissions() {
    var rxPermissions = RxPermissions();
    rxPermissions
        .request(Manifest.permission.CAMERA)
        .subscribe { granted ->
            if (granted) { // Always true pre-M
                // I can control the camera now
            } else {
                // Oups permission denied
            }
        }
}


@Composable
fun HomeScreen(){
    Button(onClick = { requestPermissions() }) {
        Text(text = "Call")
    }
}