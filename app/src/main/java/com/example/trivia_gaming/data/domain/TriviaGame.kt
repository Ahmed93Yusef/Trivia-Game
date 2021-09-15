package com.example.trivia_gaming.data.domain

import com.google.gson.annotations.SerializedName

data class TriviaGame(
    @SerializedName("response_code")
    val responseCode: Int?,
    @SerializedName("results")
    val results: List<Results>?
)