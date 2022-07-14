package edu.nextstep.camp.calculator.domain

import org.junit.Assert
import org.junit.Test


/**
 * Created by link.js on 2022. 07. 14..
 */
class OperatorTest {
    @Test
    fun `Operator는 연산자를 잘 찾아내는가`() {
        Assert.assertEquals(Operator.of("+"), Operator.PLUS)
        Assert.assertEquals(Operator.of("-"), Operator.MINUS)
        Assert.assertEquals(Operator.of("/"), Operator.DIVISION)
        Assert.assertEquals(Operator.of("*"), Operator.MULTIPLY)
    }
}