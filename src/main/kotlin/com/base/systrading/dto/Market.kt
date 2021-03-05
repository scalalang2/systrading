package com.base.systrading.dto

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import javax.persistence.Id

@Document
data class Market(
    @Id
    val id: ObjectId = ObjectId.get(),
    val name: String,
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
    val yesterday_volume: Double,
    val createdDate: LocalDateTime = LocalDateTime.now()
)