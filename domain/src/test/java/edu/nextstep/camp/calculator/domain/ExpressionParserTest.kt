package edu.nextstep.camp.calculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

internal class ExpressionParserTest {

    @DisplayName("입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException이 발생하는지 확인한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = ["", " ", "    "])
    fun blankExpressionThrow(expression: String?) {
        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { ExpressionParser.parse(expression) }
    }
}