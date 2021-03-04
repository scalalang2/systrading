package com.base.systrading.api

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CoinoneAPITests (@Autowired val coinoneApi: CoinoneAPI) {
    @Test
    fun balanceTest() {
        val balance = coinoneApi.getBalance()
        assertThat(balance.result).isEqualTo("success")
    }

    @Test
    fun orderbookTest() {
        val orderBook = coinoneApi.fetchOrderBook("BTC")
        assertThat(orderBook.ask.size).isGreaterThan(0)
        assertThat(orderBook.bid.size).isGreaterThan(0)
    }

    @Test
    fun tickerTest() {
        val ticker = coinoneApi.fetchTicker("BTC")
        assertThat(ticker.low).isLessThan(ticker.high)
    }
}