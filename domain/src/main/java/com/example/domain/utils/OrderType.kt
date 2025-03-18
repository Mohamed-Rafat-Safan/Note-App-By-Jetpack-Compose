package com.example.core.utils

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}