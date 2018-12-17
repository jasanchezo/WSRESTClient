package com.mtw.josealejandrosanchezortega.wsrestclient

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val result = URL("https://api.openweathermap.org/data/2.5/weather?zip=36723,mx&units=metric&lang=es&appid=58a99b003d10557a533499a57c99db3f").readText()

        Log.i("WS", result)
    }

    fun fetchBooks () {
        println("fetching books")

        val url = "https://api.someurl.com/v1/books?"
        val request = Request.Builder().url(url).build()

        println(request)
        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
                e?.printStackTrace()
            }
        })
    }
}
