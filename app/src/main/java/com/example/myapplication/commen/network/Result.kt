package com.example.myapplication.commen.network

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val value: T) : Result<T>()
    data class Failure(val errorHolder:ErrorHolder) : Result<Nothing>()
}

sealed class ErrorHolder(override val message: String):Throwable(message){
    data class NetworkConnection(override val message: String) : ErrorHolder(message)
    data class BadRequest(override val message: String) : ErrorHolder(message)
    data class UnAuthorized(override val message: String) : ErrorHolder(message)
    data class InternalServerError(override val message: String) :ErrorHolder(message)
    data class ResourceNotFound(override val message: String) : ErrorHolder(message)
}
