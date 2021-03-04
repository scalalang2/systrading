package com.base.systrading

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import io.github.cdimascio.dotenv.dotenv
import org.assertj.core.api.Assertions.assertThat


@SpringBootTest
class ConfigTests {
    @Test
    fun environmentLoadTest() {
        val env = dotenv()
        val accessToken = env["ACCESS_TOKEN"]
        val nothing = env["NOTHING"]
        assertThat(accessToken).isNotNull()
        assertThat(nothing).isNull()
    }
}