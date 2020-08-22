package com.gamecastonline.gamecast.network.exception

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {
    object NetworkConnection: Failure()
    data class ServerError(val throws: Throwable) : Failure()
}