package com.gamecastonline.gamecast.network.repositories

import com.gamecastonline.gamecast.network.ApiService
import com.gamecastonline.gamecast.network.entities.UrlEntity
import com.gamecastonline.gamecast.network.utils.Either
import com.gamecastonline.gamecast.network.exception.Failure
import retrofit2.HttpException
import retrofit2.Response

class UrlRepository(private val api: ApiService) {

    suspend fun getUrls(): Either<Failure, UrlEntity> {
        return request({api.getUrls()}, UrlEntity())
    }

    private suspend fun <T> request(call: suspend () -> Response<T>, default: T): Either<Failure, T> {
        return try {
            val response = call.invoke()
            when (response.isSuccessful) {
                true -> Either.Right(response.body() ?: default)
                false -> Either.Left(Failure.ServerError(HttpException(response)))
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError(exception))
        }
    }
}