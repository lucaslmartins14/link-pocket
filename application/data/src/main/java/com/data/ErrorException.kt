package com.data

sealed class ErrorException : Throwable() {
    object BadException : ErrorException()
}