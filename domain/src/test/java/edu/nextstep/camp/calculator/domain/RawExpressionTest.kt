package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import org.junit.Before
import org.junit.Test

class RawExpressionTest {

    private lateinit var builder: RawExpression.Builder

    @Before
    fun setUp() {
        builder = RawExpression.Builder()
    }

    @Test
    fun `1을 입력하고 빌드하면 1이 반환된다`() {
        // when
        val actual = builder
            .enterNumber(RawExpression.Number.ONE)
            .build()

        // then
        assertThat(actual).isEqualTo("1")
    }
}
