package com.base.systrading.task

import com.base.systrading.api.CoinoneAPI
import com.base.systrading.common.Constants
import com.base.systrading.dto.Market
import com.base.systrading.repositories.MarketRepository
import org.bson.types.ObjectId
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledTasks(@Autowired
                     val coinoneApi: CoinoneAPI,
                     val marketRepository: MarketRepository
     ){
    private val logger = LoggerFactory.getLogger(ScheduledTasks::class.java)

    /*
    * 1분에 한 번 씩 시장 데이터를 데이터베이스에 저장한다.
    * */
    @Scheduled(fixedRate=60000)
    fun saveTickers() {
        for(market in Constants.markets) {
            val ticker = coinoneApi.fetchTicker(market)
            marketRepository.save(Market(
                ObjectId.get(),
                market,
                ticker.currency,
                ticker.high,
                ticker.low,
                ticker.first,
                ticker.last,
                ticker.volume,
                ticker.yesterday_high,
                ticker.yesterday_low,
                ticker.yesterday_fist,
                ticker.yesterday_last,
                ticker.yesterday_volume
            ))
        }
    }

    /**
     * 1분에 한 번씩 트레이딩 매매 전략 봇이 전략을 수행한다.
     * */
    @Scheduled(fixedRate=60000)
    fun runTradingStrategy() {
        logger.info("[run trading strategy]")
    }
}