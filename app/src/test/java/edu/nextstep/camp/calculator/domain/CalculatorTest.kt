package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {
    @Test
    fun simpleAddition() {
        val actual: Int = Calculator.evaluateAddition(1, 3)
        assertThat(actual).isEqualTo(4)
    }

    @Test
    fun simpleAdditionBigNumber() {
        val actual: Int = Calculator.evaluateAddition(1073741823, 1073741824)
        assertThat(actual).isEqualTo(2147483647)
    }

    @Test
    fun simpleSubtraction() {
        val actual: Int = Calculator.evaluateSubtraction(0, 5)
        assertThat(actual).isEqualTo(-5)
    }

    @Test
    fun simpleMultiplication() {
        val actual: Int = Calculator.evaluateMultiplication(12, 5)
        assertThat(actual).isEqualTo(60)
    }

    @Test
    fun simpleMultiplicationWithZero() {
        val actual: Int = Calculator.evaluateMultiplication(12, 0)
        assertThat(actual).isEqualTo(0)
    }

    @Test
    fun simpleDivision() {
        val actual: Int = Calculator.evaluateDivision(12, 4)
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun evaluatesExpression() {
        val actual: Int = Calculator.evaluate("1 + 2 + 3")
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun evaluatesComplexExpression() {
        val actual: Int = Calculator.evaluate("2 + 3 * 4 / 3")
        assertThat(actual).isEqualTo(6)
    }

    @Test(expected = IllegalArgumentException::class)
    fun unsupportedOperator() {
        Calculator.evaluate("1 _ 1")
    }

    @Test(expected = IllegalArgumentException::class)
    fun nullStringExpression() {
        Calculator.evaluate("null")
    }

    @Test(expected = IllegalArgumentException::class)
    fun emptyStringExpression() {
        Calculator.evaluate("")
    }

    @Test(expected = ArithmeticException::class)
    fun divideByZero() {
        Calculator.evaluate("1 / 0")
    }
}
