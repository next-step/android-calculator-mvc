package edu.nextstep.camp.calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class OperationTest {
    @DisplayName("계산이 성공하는지 확인.")
    @ParameterizedTest
    @CsvSource("+ 7,11", "- 1,3", "× 3,12", "÷ 2,2")
    fun happyPath(input: String, expected: Int) {
        val chunk = input.split(DELIMITER)
        Assertions.assertThat(Operation.from(chunk).calculate(ACCUMULATED))
            .isEqualTo(expected)
    }

    @DisplayName("계산식이 완성되지 않았을 경우 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = ["", "      ", "+", " - ", "11"])
    fun illegalOperation(input: String) {
        val chunk = input.split(DELIMITER)
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Operation.from(chunk).calculate(ACCUMULATED) }
            .withMessage("완전하지 않은 계산식입니다.")
    }

    companion object {
        private const val DELIMITER = " "
        private const val ACCUMULATED = 4
    }
}
