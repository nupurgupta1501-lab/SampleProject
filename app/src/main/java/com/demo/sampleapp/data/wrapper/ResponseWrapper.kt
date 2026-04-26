package com.demo.sampleapp.data.wrapper

sealed class ResponseWrapper<out T> {
    data class Success<out T>(val data: T) : ResponseWrapper<T>()
    data class Error(val message: String, val cause: Throwable? = null) : ResponseWrapper<Nothing>()
    object Loading : ResponseWrapper<Nothing>()
}