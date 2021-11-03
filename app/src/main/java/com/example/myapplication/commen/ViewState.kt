package com.example.myapplication.commen

sealed class ViewState<T> {
    class Loading<T>(): ViewState<T>()
    class Error<T>(val message: String): ViewState<T>()
    class Succes<T>(val item: T) : ViewState<T>()
}