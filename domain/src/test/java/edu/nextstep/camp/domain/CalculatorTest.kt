package edu.nextstep.camp.domain

import com.example.domain.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class CalculatorTest {
    @Test
    fun testAdd() {
        //given
        val expression = "2 + 3"
        val delimiter = " "
        val expected = 5

        //then
        assertThat(Calculator.evaluate(expression, delimiter)).isEqualTo(expected)
    }

    @Test
    fun testSubtract() {
        //given
        val expression = "2 - 3"
        val delimiter = " "
        val expected = -1

        //then
        assertThat(Calculator.evaluate(expression, delimiter)).isEqualTo(expected)
    }

    @Test
    fun testMultiply() {
        //given
        val expression = "2 * 3"
        val delimiter = " "
        val expected = 6

        //then
        assertThat(Calculator.evaluate(expression, delimiter)).isEqualTo(expected)
    }

    @Test
    fun testDivide() {
        //given
        val expression = "4 / 2"
        val delimiter = " "
        val expected = 2

        //then
        assertThat(Calculator.evaluate(expression, delimiter)).isEqualTo(expected)
    }

    @Test
    fun evaluatesExpression() {
        //given
        val expression = "1 - 2 + 3 * 4 / 2"
        val delimiter = " "
        val expected = 4

        //then
        assertThat(Calculator.evaluate(expression, delimiter)).isEqualTo(expected)
    }

    @Test
    fun testNonArithmeticOperatorInput() {
        //given
        val expression = "2 $ 3"
        val delimiter = " "

        //then
        assertThrows<IllegalArgumentException> { Calculator.evaluate(expression, delimiter) }
    }

    @Test
    fun testNullInput() {
        //given
        val expression = ""
        val delimiter = " "

        //then
        assertThrows<IllegalArgumentException> { Calculator.splitExpression(expression, delimiter) }
    }

    @Test
    fun testBlankInput() {
        //given
        val expression = " "
        val delimiter = " "

        //then
        assertThrows<IllegalArgumentException> { Calculator.splitExpression(expression, delimiter) }
    }

}