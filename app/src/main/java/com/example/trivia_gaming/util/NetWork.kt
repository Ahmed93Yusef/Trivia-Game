package com.example.trivia_gaming.util

import android.app.Activity
import android.util.Log
import com.example.trivia_gaming.data.DataManager
import com.example.trivia_gaming.data.domain.TriviaGame
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

object NetWork {
    private val client = OkHttpClient()
    private val gson = Gson()
    fun makeRequestUsingOkhttp(activity: Activity, adapter: ItemAdapter){
        val request = Request.Builder().url(DataManager.url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("START_FRAGMENT","failed${e.message}")
            }
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val results = gson.fromJson(body,TriviaGame::class.java)
                    activity.runOnUiThread {
                        results.results?.let { DataManager.addData(it) }
                        adapter.notifyDataSetChanged()
                    }
            }
        })
    }
}