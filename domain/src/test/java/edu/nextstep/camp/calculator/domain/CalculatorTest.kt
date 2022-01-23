package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.calculator.Calculator
import edu.nextstep.camp.calculator.domain.expression.ExpressionParser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

private const val DELIMITER = " "

internal class CalculatorTest {

    private val expressionParser = ExpressionParser(DELIMITER)
    private val calculator = Calculator(expressionParser)

    @ParameterizedTest(name = "기본 수식이 성공하는지 확인한다. [{index}] {0}")
    @CsvSource(
        "1 + 2 + 3 + 4 + 5 = 15",
        "5 - 4 - 3 - 2 - 1 = -5",
        "1 × 2 × 3 × 4 × 5 = 120",
        "5 ÷ 4 ÷ 3 ÷ 2 ÷ 1 = 0",
        "2 + 5 × 8 - 4 ÷ 3 = 17",
        delimiter = '='
    )
    fun basicExpression(expression: String, result: String) {
        // then
        assertThat(calculator.evaluate(expression)).isEqualTo(result)
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException이 발생하는지 확인한다.")
    @Test
    fun notArithmeticOperatorThrow() {
        // given
        val expression = "2 + 5 × 8 - 4 % 3"

        // then
        assertThrows<IllegalArgumentException> { calculator.evaluate(expression) }
    }
}