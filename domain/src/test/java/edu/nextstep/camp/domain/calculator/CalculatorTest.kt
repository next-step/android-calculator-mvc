package edu.nextstep.camp.domain.calculator

import edu.nextstep.camp.domain.calculator.Calculator
import edu.nextstep.camp.domain.expression.ExpressionParser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

private const val DELIMITER = " "

class CalculatorTest {
    private val expressionParser = ExpressionParser(DELIMITER)
    private val calculator = Calculator(expressionParser)

    @Test
    fun testAdd() {
        //given
        val expression = "2 + 3"
        val expected = "5"

        //when
        val result = calculator.evaluate(expression)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun testSubtract() {
        //given
        val expression = "2 - 3"
        val expected = "-1"

        //when
        val result = calculator.evaluate(expression)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun testMultiply() {
        //given
        val expression = "2 × 3"
        val expected = "6"

        //when
        val result = calculator.evaluate(expression)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun testDivide() {
        //given
        val expression = "4 ÷ 2"
        val expected = "2"

        //when
        val result = calculator.evaluate(expression)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun evaluatesExpression() {
        //given
        val expression = "1 - 2 + 3 × 4 ÷ 2"
        val expected = "4"

        //when
        val result = calculator.evaluate(expression)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun testNonArithmeticOperatorInput() {
        //given
        val expression = "2 $ 3"

        //when
        val actualException = runCatching {
            calculator.evaluate(expression)
        }.exceptionOrNull()

        //then
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessage("사칙연산 기호가 아닙니다")
    }

    @Test
    fun testNullInput() {
        //given
        val expression = ""

        //when
        val actualException = runCatching {
            calculator.evaluate(expression)
        }.exceptionOrNull()

        //then
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessage("입력값이 null 이거나 빈 공백 문자입니다")
    }

    @Test
    fun testBlankInput() {
        //given
        val expression = " "

        //when
        val actualException = runCatching {
            calculator.evaluate(expression)
        }.exceptionOrNull()

        //then
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessage("입력값이 null 이거나 빈 공백 문자입니다")
    }

    @Test
    fun testDividedByZero() {
        //given
        val expression = "1 ÷ 0"

        //when
        val actualException =
            runCatching {
                calculator.evaluate(expression)
            }.exceptionOrNull()

        //then
        assertThat(actualException).isInstanceOf(ArithmeticException::class.java)
    }
}