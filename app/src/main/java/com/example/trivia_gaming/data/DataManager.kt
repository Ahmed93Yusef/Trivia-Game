package com.example.trivia_gaming.data

import com.example.trivia_gaming.data.domain.Results

object DataManager {
    private val dataList = mutableListOf<Results>()
    private var myUrl: String = ""
    private val list = listOf("easy","medium","hard")
    private var initResult = 0

    val dataGame: List<Results>
    get() = dataList

    val url: String
    get() = myUrl

    val difficultyList: List<String>
    get() = list

    val results: Int
    get() = initResult

    fun addData(list: List<Results>){
        list.forEach {
            dataList.add(it)
        }
    }
    fun getUrl(amount: String? ="10",category: String? = "10",difficulty: String? = "easy"){
        myUrl = "https://opentdb.com/api.php?" +
                "amount=${amount}" +
                "&category=${category}" +
                "&difficulty=${difficulty}" +
                "&type=multiple\n"
    }
    fun getResults(result: Int, size: Int) {
        initResult = (result/size)*100
    }

}