package com.base.systrading.api

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CoinoneAPITests (@Autowired val coinoneApi: CoinoneAPI) {
    @Test
    fun balanceTest() {
        coinoneApi.getBalance()
    }
}