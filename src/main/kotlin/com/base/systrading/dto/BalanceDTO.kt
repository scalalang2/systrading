package com.base.systrading.dto

data class BalanceDetailDTO(
    val avail: Double,
    val balance: Double
)

data class BalanceDTO(
    val result: String,
    val errorCode: String,
    val krw: BalanceDetailDTO
)