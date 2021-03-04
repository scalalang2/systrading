package com.base.systrading.api

import com.base.systrading.dto.BalanceDTO
import com.base.systrading.dto.OrderbookDTO
import com.base.systrading.dto.TickerDTO
import com.google.gson.Gson
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
        apiKey = env["ACCESS_TOKEN"]
    }

    fun getBalance() : BalanceDTO {
        val request = HttpRequest.newBuilder()
            .uri(URI.create(apiUrl + "v1/account/balance?access_token=$apiKey"))
            .GET()
            .build()

        val client = HttpClient.newHttpClient()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return Gson().fromJson(response.body(), BalanceDTO::class.java)
    }

    /*
    * 현재 시장에 등록된 bid/ask 오더북 정보를 조회한다.
    * */
    fun fetchOrderBook(market: String) : OrderbookDTO {
        val uri = "orderbook?currency=$market"
        val client = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create("${apiUrl}${uri}"))
            .GET()
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return Gson().fromJson(response.body(), OrderbookDTO::class.java)
    }

    /*
    * 현재 시장의 종가, 최고가, 죄저가 등의 정보를 조회한다.
    * */
    fun fetchTicker(market: String) : TickerDTO {
        val uri = "ticker?currency=$market"
        val client = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create("${apiUrl}${uri}"))
            .GET()
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return Gson().fromJson(response.body(), TickerDTO::class.java)
    }
}