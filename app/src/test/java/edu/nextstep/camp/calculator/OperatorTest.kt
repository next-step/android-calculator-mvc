package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.Operator
import org.junit.Test

class OperatorTest {

    @Test(expected = IllegalArgumentException::class)
    fun `사칙연산 기호외 다른 문자가 파라미터로 넘겨진 경우 Exception 발생`() {
        //when
        val notOperatorString = "="

        //then
        Operator(notOperatorString)
    }
}