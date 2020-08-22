package com.gamecastonline.gamecast.network

import com.gamecastonline.gamecast.network.entities.UrlEntity
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("url")
    suspend fun getUrls(): Response<UrlEntity>
}