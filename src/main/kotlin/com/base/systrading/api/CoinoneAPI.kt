package com.base.systrading.api

import io.github.cdimascio.dotenv.dotenv
import org.springframework.stereotype.Service

@Service
class CoinoneAPI {
    private var apiUrl = "https://api.coinone.co.kr/"
    private var apiKey = ""
    private var secretKey = ""

    init {
        val env = dotenv()
        apiKey = env["API_KEY"]
        secretKey = env["SECRET_KEY"]
    }

    fun getEncodedPayload(payload: String) {
        
    }

    fun getSignature(encodedPayload: String) {

    }
}