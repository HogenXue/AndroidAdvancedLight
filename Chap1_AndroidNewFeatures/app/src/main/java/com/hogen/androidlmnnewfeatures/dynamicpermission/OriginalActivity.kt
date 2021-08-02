package com.hogen.androidlmnnewfeatures.dynamicpermission

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import com.hogen.androidlmnnewfeatures.R

class OriginalActivity : AppCompatActivity() {

    val PERMISSION_REQUEST_PHONE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button: Button = findViewById(R.id.btn_request);

        button.setOnClickListener {
            call()
        }
    }

    private fun call() {
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED){
            requestPermissions(this,
                arrayOf(Manifest.permission.CALL_PHONE),PERMISSION_REQUEST_PHONE)
        }else{
            callPhone()
        }
    }

    private fun callPhone() {
        var intent = Intent(Intent.ACTION_CALL)
        var uri = Uri.parse("tel:" + 10086);
        intent.data = uri
        try {
            startActivity(intent)
        }catch (e:Exception) {
            e.printStackTrace()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == PERMISSION_REQUEST_PHONE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                callPhone()
            }else{
                if(!ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){
                    showRequestPermissionRationale()
                }
            }
            return
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    fun showRequestPermissionRationale(){
        AlertDialog.Builder(this)
        .setMessage("If not allowed, APP will not work anymore!")
        .setPositiveButton("Confirm", {DialogInterface, i: Int ->Unit}).show()
    }
}