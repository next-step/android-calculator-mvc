package edu.nextstep.camp.calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

/**
 * Created by link.js on 2022. 07. 13..
 */

class CalculatorTest {
    private val calculator = Calculator()

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource("2 + 3, 5",
        "5 - 2, 3",
        "5 * 3, 15",
        "5 + 3 / 4, 2",
        "2 + 3 * 4 / 2, 10",
        "200 - 10 / 10, 19")
    fun `계산기가 정상 동작한다`(expression: String, answer: Int) {
        assertEquals(Calculator().evaluate(expression), answer)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw`(source: String?) {
        assertThrows<IllegalArgumentException> {
            calculator.evaluate(source)
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        assertThrows<IllegalArgumentException> {
            calculator.evaluate("2 ] 3")
        }
    }

    @Test
    fun `숫자 위치에 숫자가 아닌 경우 IllegalArgumentException throw`() {
        assertThrows<IllegalArgumentException> {
            calculator.evaluate("2 3 3")
        }
    }

    @Test
    fun `0으로 나눌 경우 IllegalArgumentException throw`() {
        assertThrows<IllegalArgumentException> {
            calculator.evaluate("2 / 0")
        }
    }

    @Test
    fun `연산자와 피연산자 갯수가 맞지 않는 경우 IllegalArgumentException throw`() {
        assertThrows<IllegalArgumentException> {
            calculator.evaluate("2 / 0 +")
        }
    }
}