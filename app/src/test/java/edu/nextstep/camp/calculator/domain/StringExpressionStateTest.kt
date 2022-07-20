package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class StringExpressionStateTest {

    @ParameterizedTest(name = "{0} 수식에 피연산자 {1}을 추가하면 {2}가 된다.")
    @CsvSource(
        "1 +, 2, 1 + 2",
        "1 - 2, 3, 1 - 23",
        "1 / 2 + 3, 45, 1 / 2 + 345",
    )
    fun `수식에 새로운 피연산자를 추가할 수 있다`(given: String, operandNumber: Int, expected: String) {
        // given
        val givenExpression = StringExpressionState.of(given)
        val operand = Operand(operandNumber)

        // when
        val result = givenExpression.addElement(operand)

        // then
        assertThat(result.toString()).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} 수식에 연산자 {1}을 추가하면 {2}가 된다.")
    @CsvSource(
        "1, /, 1 /",
        "1 / 21 + 3, *, 1 / 21 + 3 *",
        "'', +, ''",
    )
    fun `수식에 새로운 연산자를 추가할 수 있다`(given: String, operatorSymbol: String, expected: String) {
        // given
        val givenExpression = StringExpressionState.of(given)
        val operator = Operator.of(operatorSymbol)

        // when
        val result = givenExpression.addElement(operator)

        // then
        assertThat(result.toString()).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} 수식에서 마지막 요소를 제거하면 {1}가 된다.")
    @CsvSource(
        "9, ''",
        "123 -, 123",
        "1 + 23, 1 + 2",
        "1 + 234, 1 + 23",
        "'', ''",
    )
    fun `수식의 마지막 요소를 제거할 수 있다`(given: String, expected: String) {
        // given
        val givenExpression = StringExpressionState.of(given)

        // when
        val result = givenExpression.removeElement()

        // then
        assertThat(result.toString()).isEqualTo(expected)
    }
}
