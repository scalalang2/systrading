package com.base.systrading.dto

data class TickerDTO(
    val result: String,
    val errorCode: String,
    val timestamp: Long,
    val currency: String,
    val high: Double,
    val low: Double,
    val first: Double,
    val last: Double,
    val volume: Double,
    val yesterday_high: Double,
    val yesterday_low: Double,
    val yesterday_fist: Double,
    val yesterday_last: Double,
    val yesterday_volume: Double
)