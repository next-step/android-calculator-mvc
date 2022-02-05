package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import edu.nextstep.camp.calculator.domain.calculator.StringCalculator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class StringCalculatorTest {
    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException 이 Throw 된다.")
    @ParameterizedTest
    @EmptySource
    fun validateTest_inputNullOrEmpty(formula: String) {
        val stringCalculator = StringCalculator()

        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(formula)
        }
    }

    @DisplayName("연산자가 사칙연산의 연산자가 아닐 경우 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1 @ 3", "1 + 2 & 3"])
    fun validateTest_checkSupportOperator(formula: String) {
        val stringCalculator = StringCalculator()

        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(formula)
        }
    }

    @DisplayName("불완전한 수식이 파라메터로 입력될 경우 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @CsvSource(value = ["0 +,0", "1,1", "1 + 2 * 3 +,9"])
    fun validateTest_checkFormulaFormat(formula: String, expected: Double) {
        val stringCalculator = StringCalculator()

        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(formula)
        }
    }

    @DisplayName("+ 로 이루어진 연산자들의 계산이 정상적으로 된다.")
    @ParameterizedTest
    @CsvSource(value = ["1 + 2,3.0", "1 + 4 + 6,11.0", "10 + 21 + 30 + 0,61.0"])
    fun calculateTest_plus(formula: String, expected: Double) {
        val stringCalculator = StringCalculator()

        val result = stringCalculator.calculate(formula)

        Truth.assertThat(result).isEqualTo(expected)
    }

    @DisplayName("* 로 이루어진 연산자들의 계산이 정상적으로 된다.")
    @ParameterizedTest
    @CsvSource(value = ["1 * 2,2", "1 * 4 * 6,24", "2 * 21 * 0 * 1,0"])
    fun calculateTest_multiple(formula: String, expected: Double) {
        val stringCalculator = StringCalculator()

        val result = stringCalculator.calculate(formula)

        Truth.assertThat(result).isEqualTo(expected)
    }

    @DisplayName("- 로 이루어진 연산자들의 계산이 정상적으로 된다.")
    @ParameterizedTest
    @CsvSource(value = ["1 - 2,-1", "-1 - 4 - 6,-11", "10 - 2,8"])
    fun calculateTest_minus(formula: String, expected: Double) {
        val stringCalculator = StringCalculator()

        val result = stringCalculator.calculate(formula)

        Truth.assertThat(result).isEqualTo(expected)
    }

    @DisplayName("/ 로 이루어진 연산자들의 계산이 정상적으로 된다.")
    @ParameterizedTest
    @CsvSource(value = ["1 / 2,0.5", "8 / 4 / 2,1", "10 / 2,5"])
    fun calculateTest_divide(formula: String, expected: Double) {
        val stringCalculator = StringCalculator()

        val result = stringCalculator.calculate(formula)

        Truth.assertThat(result).isEqualTo(expected)
    }

    @DisplayName("다양한 연산자로 이루어진 연산자들의 계산이 정상적으로 된다.")
    @ParameterizedTest
    @CsvSource(value = ["1 + 2 * 3,9", "3 / 2 - 1,0.5", "100 - 2 + 3 * 2 / 2,101"])
    fun calculateTest_variousOperator(formula: String, expected: Double) {
        val stringCalculator = StringCalculator()

        val result = stringCalculator.calculate(formula)

        Truth.assertThat(result).isEqualTo(expected)
    }
}