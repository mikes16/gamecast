package com.gamecastonline.gamecast.network.entities

import com.google.gson.annotations.SerializedName

data class LiveStreamEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)