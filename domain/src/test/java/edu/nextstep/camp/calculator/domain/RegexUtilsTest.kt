package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream


class RegexUtilsTest {

    @ParameterizedTest(name = "#{index}) {0} is invalid expression starting with operator")
    @ValueSource(
        strings = ["-1+10+11", "+12+10", "×12123+1", "÷12123+1"]
    )
    fun checkInvalidExpressionStartingWithOperator(expression: String) {
        assertThat(RegexUtils.checkExpressionIsValid(expression)).isEqualTo(false)
    }

    @ParameterizedTest(name = "#{index}) {0} is valid expression")
    @ValueSource(
        strings = ["1+10+11", "1", "1÷10+30110×11", "13÷0+3123110×11"]
    )
    fun checkValidExpressions(expression: String) {
        assertThat(RegexUtils.checkExpressionIsValid(expression)).isEqualTo(true)
    }

    @ParameterizedTest(name = "#{index}) {0} is invalid expression")
    @ValueSource(
        strings = ["1++10+11", "nul1", "1+10+11text+2", " ", ""]
    )
    fun checkInvalidExpressions(expression: String) {
        assertThat(RegexUtils.checkExpressionIsValid(expression)).isEqualTo(false)
    }

    @ParameterizedTest(name = "#{index}) {0} is one digit number expression")
    @ValueSource(
        strings = ["1", "3", "0", "9", "2"]
    )
    fun checkValidOneDigitExpression(expression: String) {
        assertThat(RegexUtils.checkExpressionIsOneDigitNumber(expression)).isEqualTo(true)
    }

    @ParameterizedTest(name = "#{index}) {0} is one digit number expression")
    @ValueSource(
        strings = ["11", "-3", "401", "19", "t"]
    )
    fun checkInvalidOneDigitExpression(expression: String) {
        assertThat(RegexUtils.checkExpressionIsOneDigitNumber(expression)).isEqualTo(false)
    }

    @ParameterizedTest(name = "#{index}) operators in \"{0}\" is {1}")
    @MethodSource("provideOperatorsList")
    fun givenValidExpressions_WhenGetOperatorsList_ThenReturnOperatorsList(expression: String, expected: List<String>) {
        assertThat(RegexUtils.getOperatorsList(expression)).isEqualTo(expected)
    }

    @ParameterizedTest(name = "#{index}) operands in \"{0}\" is {1}")
    @MethodSource("provideOperandsList")
    fun givenValidExpressions_WhenGetOperandsList_ThenReturnOperandsList(expression: String, expected: List<Int>) {
        assertThat(RegexUtils.getOperandsList(expression)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun provideOperatorsList() : Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 + 1 ÷ 1 + 2", listOf("+", "÷", "+")),
                Arguments.of("1 × 1231 ÷ 1 + 2 - 4", listOf("×", "÷", "+", "-")),
            )
        }
        @JvmStatic
        private fun provideOperandsList() : Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 + 1 ÷ 1 + 2", listOf(1, 1, 1, 2)),
                Arguments.of("1 × 1231 ÷ 1 + 2 - 4", listOf(1, 1231, 1, 2, 4)),
            )
        }
    }
}
