package edu.nextstep.camp.caculator.domain

import edu.nextstep.camp.calculator.domain.Operator
import org.junit.Assert.assertThrows
import org.junit.Test

class OperatorTest {
    @Test
    fun `잘못된_수식을_입력하면_에러를_낸다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Operator.getOperated(accumulated = 32, nextInt = 2, operatorMark = "r")
        }
    }
}