package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource

internal class StringCalculatorTest {

    private val stringCalculator = StringCalculator

    @ParameterizedTest(name = "사칙연산자 하나가 포함된 {0}의 계산 결과가 {1}를 만족한다.")
    @CsvSource(
        "1 + 2, 3",
        "1004 - 4, 1000",
        "10 * 5, 50",
        "24 / 6, 4",
    )
    fun `사칙연산 기호 하나가 포함된 문자열의 계산 결과값을 알 수 있다`(input: String, expected: Int) {
        // when
        val result = stringCalculator.calculate(input)

        // then
        assertThat(result).isEqualTo(Operand(expected))
    }

    @ParameterizedTest(name = "사칙연산자 여러 개가 포함된 {0}의 계산 결과가 {1}를 만족한다.")
    @CsvSource(
        "1 + 2 + 3 + 4 + 5, 15",
        "1004 - 4 / 2, 500",
        "10 * 5 / 10, 5",
    )
    fun `사칙연산 기호 여러 개가 포함된 문자열의 계산 결과값을 알 수 있다`(input: String, expected: Int) {
        // when
        val result = stringCalculator.calculate(input)

        // then
        assertThat(result).isEqualTo(Operand(expected))
    }

    @ParameterizedTest
    @EmptySource
    fun `입력값이 빈 공백 문자일 경우 IllegalArgumentException이 발생한다`(input: String) {
        // then
        assertThrows<IllegalArgumentException> { stringCalculator.calculate(input) }
    }

    @ParameterizedTest(name = "사칙연산 기호가 아닌 {0}의 경우 IllegalArgumentException이 발생한다")
    @CsvSource(
        "1 @ 2",
        "1 + 2 ( 3",
        "1 # 3",
    )
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException이 발생한다`(input: String) {
        // then
        val exception = assertThrows<IllegalArgumentException> { stringCalculator.calculate(input) }
        assertThat(exception.message).contains("해당하는 Operator를 찾을 수 없습니다.")
    }

    @ParameterizedTest(name = "피연산자가 숫자가 아닌 {0}의 경우 IllegalArgumentException이 발생한다")
    @CsvSource(
        "+",
        "- + 3",
        "1(3)",
    )
    fun `피연산자가 숫자가 아닌 경우 IllegalArgumentException이 발생한다`(input: String) {
        // then
        val exception = assertThrows<IllegalArgumentException> { stringCalculator.calculate(input) }
        assertThat(exception.message).contains("해당하는 Operand를 찾을 수 없습니다.")
    }

    @ParameterizedTest(name = "완전하지 않은 수식인 {0}의 경우 IllegalArgumentException이 발생한다")
    @CsvSource(
        "1 +",
        "2 - 8 +",
    )
    fun `완전하지 않은 수식인 경우 IllegalArgumentException이 발생한다`(input: String) {
        // then
        val exception = assertThrows<IllegalArgumentException> { stringCalculator.calculate(input) }
        assertThat(exception.message).contains("완전하지 않은 수식")
    }
}
