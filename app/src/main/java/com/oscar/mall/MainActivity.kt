package com.oscar.mall

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.oscar.malllibrary.net.RestClient
import com.oscar.malllibrary.net.callback.ISuccess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RestClient
            .builder()
            .url("index.php")
            .loader(this)
            .success(object : ISuccess{
                override fun onSuccess(response: String) {
                    Toast.makeText(baseContext, response, Toast.LENGTH_LONG).show()
                }
            })
            .build()
            .get()
    }
}