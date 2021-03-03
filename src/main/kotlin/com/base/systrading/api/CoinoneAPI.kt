package com.base.systrading.api

import io.github.cdimascio.dotenv.dotenv
import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
class CoinoneAPI {
    private var apiUrl = "https://api.coinone.co.kr/"
    private var apiKey = ""

    init {
        val env = dotenv()
        apiKey = ""
    }

    fun getBalance() {
        println(apiKey)
        val request = HttpRequest.newBuilder()
            .uri(URI.create(apiUrl + "v1/account/balance?access_token=" + apiKey))
            .GET()
            .build()

        val client = HttpClient.newHttpClient()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        println(response.body())
    }
}