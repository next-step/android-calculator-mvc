package edu.nextstep.camp.calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


/**
 * Created by link.js on 2022. 07. 14..
 */
class OperatorTest {
    @Test
    fun `Operator는 연산자를 잘 찾아내는가`() {
        assertEquals(Operator.of("+"), Operator.PLUS)
        assertEquals(Operator.of("-"), Operator.MINUS)
        assertEquals(Operator.of("/"), Operator.DIVISION)
        assertEquals(Operator.of("*"), Operator.MULTIPLY)
    }
}