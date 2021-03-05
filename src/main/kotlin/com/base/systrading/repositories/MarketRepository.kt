package com.base.systrading.repositories

import com.base.systrading.dto.Market
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface MarketRepository : MongoRepository<Market, String> {
    fun findOneById(id: ObjectId): Market
}