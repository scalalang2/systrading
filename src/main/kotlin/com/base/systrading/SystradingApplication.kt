package com.base.systrading

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import io.github.cdimascio.dotenv.dotenv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class SystradingApplication {
    @Bean
    fun mongoClient(): MongoClient {
        val env = dotenv()
        return MongoClients.create(env["MONGODB_URI"])
    }
}

fun main(args: Array<String>) {
    runApplication<SystradingApplication>(*args)
}
