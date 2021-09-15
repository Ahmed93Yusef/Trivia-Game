package com.example.trivia_gaming.data

import com.example.trivia_gaming.data.domain.Results

object DataManager {
    private val dataList = mutableListOf<Results>()

    val dataGame: List<Results>
    get() = dataList

    fun addData(list: List<Results>){
        list.forEach {
            dataList.add(it)
        }
    }

}