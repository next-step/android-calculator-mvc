package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.Calculator.calculate
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {
    @DisplayName("예시로 나온 계산이 성공하는지 확인.")
    @ParameterizedTest
    @CsvSource("2 + 3 * 4 / 2,10", "15 - 3 / 3,4")
    fun happyPath(input: String, result: Int) {
        assertThat(calculate(input))
            .isEqualTo(result)
    }

    @DisplayName("입력값이 빈 공백 문자일 경우 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "  "])
    fun blankInput(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { calculate(input) }
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException 이 발생한다.")
    @Test
    fun illegalOperator() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {  calculate("5 % 2") }
            .withMessage("허용되지 않은 연산자 입니다.")
    }
}
