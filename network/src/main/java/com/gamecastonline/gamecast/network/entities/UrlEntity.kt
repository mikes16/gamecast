package com.gamecastonline.gamecast.network.entities

import com.google.gson.annotations.SerializedName

data class UrlEntity(
    @SerializedName("live-streams" +
            "")
    val liveStreamEntity: List<LiveStreamEntity> = mutableListOf()
)