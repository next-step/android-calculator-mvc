package edu.nextstep.camp.caculator

import com.google.common.truth.Truth.*
import edu.nextstep.camp.caculator.domain.Expression
import org.junit.Test

class ExpressionTest {

    @Test
    fun 정상_케이스() {
        // When
        val actual = Expression("2 + 2 - 2 * 2 / 2")

        // Then
        assertThat(actual.getExpressionList()).isEqualTo(listOf("2", "+", "2", "-", "2", "*", "2", "/", "2"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun 비정상_공백문자열() {
        // When
        Expression("     ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun 비정상_빈문자열() {
        // When
        Expression("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun 비정상_허용하지_않는_문자열() {
        // When
        Expression("test")
    }
}