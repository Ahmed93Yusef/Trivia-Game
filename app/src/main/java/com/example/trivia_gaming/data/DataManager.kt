package com.example.trivia_gaming.data

import com.example.trivia_gaming.data.domain.Results

object DataManager {
    private val dataList = mutableListOf<Results>()
    private var myUrl: String = ""

    val dataGame: List<Results>
    get() = dataList

    val url: String
    get() = myUrl

    fun addData(list: List<Results>){
        list.forEach {
            dataList.add(it)
        }
    }
    fun getUrl(amount: Int = 1,category: Int = 10,difficulty: String = "easy"){
        myUrl = "https://opentdb.com/api.php?" +
                "amount=${amount}" +
                "&category=${category}" +
                "&difficulty=${difficulty}" +
                "&type=multiple\n"
    }

}