package edu.nextstep.camp.caculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.caculator.domain.Expression
import org.junit.Test

class ExpressionTest {

    @Test
    fun 정상_케이스() {
        // When
        val expression = Expression()
        expression.addExpression("2")
        expression.addExpression("+")
        expression.addExpression("2")
        expression.addExpression("-")
        expression.addExpression("2")
        expression.addExpression("*")
        expression.addExpression("2")
        expression.addExpression("/")
        expression.addExpression("2")

        // Then
        assertThat(expression.getExpressionString()).isEqualTo("2 + 2 - 2 * 2 / 2")
    }

    @Test(expected = IllegalArgumentException::class)
    fun 비정상_공백문자열() {
        // When
        val expression = Expression()
        expression.addExpression("        ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun 비정상_빈문자열() {
        // When
        val expression = Expression()
        expression.addExpression("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun 비정상_허용하지_않는_문자열() {
        // When
        val expression = Expression()
        expression.addExpression("test")
    }

    @Test
    fun 입력된_수식이_완전한지_검증() {
        // Given
        val expression = Expression()
        expression.addExpression("2")
        expression.addExpression("+")


        // When
        val actual = expression.isValidExpression()

        // Then
        assertThat(actual).isFalse()
    }
}