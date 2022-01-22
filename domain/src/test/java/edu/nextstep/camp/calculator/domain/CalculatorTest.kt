package edu.nextstep.camp.calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CalculatorTest {

    private val calculator = Calculator()

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

    @DisplayName("3 + 2 -> = 클릭 -> 5")
    @Test
    fun `입력된 수신이 완전할 때, 사용자가 = 버튼을 누르면 입력된 수식의 결과가 화면에 보여야 한다`() {
        // given
        calculator.insert("3")
        calculator.insert("+")
        calculator.insert("2")

        // when
        calculator.evaluate()

        // then
        val actual1 = calculator.result
        assertThat(actual1).isInstanceOf(Calculator.Result.Success::class.java)

        val actual2 = (calculator.result as Calculator.Result.Success).value
        assertThat(actual2).isEqualTo("5")
    }

    @DisplayName("3 + -> = 클릭 -> 에러 결과 반환")
    @Test
    fun `입력된 수신이 완전하지 않을 때, 사용자가 = 버튼을 눌렀을 때 에러 결과가 반환 되어야 한다`() {
        // given
        calculator.insert("3")
        calculator.insert("+")

        // when
        calculator.evaluate()

        // then
        val actual = calculator.result
        assertThat(actual).isInstanceOf(Calculator.Result.Failure::class.java)
    }
}