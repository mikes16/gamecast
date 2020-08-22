package com.gamecastonline.gamecast.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BACKEND_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient().newBuilder()

    if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
    }

    okHttpClientBuilder.addInterceptor { chain ->
        val newRequest = chain.request().newBuilder()
            .addHeader("CUSTOM-AUTH", "Sergio-Miguel")
            .build()
        chain.proceed(newRequest)
    }

    //
    // Sergio-Miguel

    return okHttpClientBuilder.build()
}

fun provideApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}