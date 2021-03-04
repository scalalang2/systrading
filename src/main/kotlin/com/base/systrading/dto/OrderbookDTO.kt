package com.base.systrading.dto

data class OrderInfoDTO(
    val qty: Double,
    val price: Double
)

data class OrderbookDTO(
    val errorCode: String,
    val timestamp: String,
    val currency: String,
    val result: String,
    val bid: List<OrderInfoDTO>,
    val ask: List<OrderInfoDTO>
)