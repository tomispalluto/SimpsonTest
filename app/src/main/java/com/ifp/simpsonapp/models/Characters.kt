package com.ifp.simpsonapp.models

import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("quote")
    val phrase: String,
    @SerializedName("character")
    val character: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("characterDirection")
    val characterDirection: String
)
