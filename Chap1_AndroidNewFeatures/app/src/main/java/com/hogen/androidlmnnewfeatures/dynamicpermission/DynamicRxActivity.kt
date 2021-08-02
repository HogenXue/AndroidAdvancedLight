package com.hogen.androidlmnnewfeatures.dynamicpermission

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.hogen.androidlmnnewfeatures.ui.theme.AndroidLMNNewFeaturesTheme
import com.tbruyelle.rxpermissions3.RxPermissions

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
                    HomeScreen(this)
                }
            }
        }
    }
}


private fun requestPermissions(context:AppCompatActivity) {
    var rxPermissions = RxPermissions(context);
    rxPermissions
        .request(Manifest.permission.CAMERA)
        .subscribe { granted ->
            if (granted) { // Always true pre-M
                // I can control the camera now
                Toast.makeText(context,"Ooops", Toast.LENGTH_SHORT).show()
            } else {
                // Oups permission denied
                Toast.makeText(context,"Denied", Toast.LENGTH_SHORT).show()
            }
        }
}


@Composable
fun HomeScreen(context:AppCompatActivity){
    Button(onClick = { requestPermissions(context) }) {
        Text(text = "Call")
    }
    Text(text = "JetpackCompose")
}