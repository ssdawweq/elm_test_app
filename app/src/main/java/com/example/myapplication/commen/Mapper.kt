package com.example.myapplication.commen

interface Mapper<T,R> {
    fun mapTo(item: T) : R
}