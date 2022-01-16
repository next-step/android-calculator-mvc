package edu.nextstep.camp.calculator.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

internal class ExpressionParserTest {

    @DisplayName("입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException이 발생하는지 확인한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = ["", " ", "    "])
    fun blankExpressionThrow(expression: String?) {
        // given
        val delimiter = " "

        // then
        assertThrows<IllegalArgumentException> { ExpressionParser.parse(expression, delimiter) }
    }
}