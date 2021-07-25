package edu.nextstep.camp.calculator

import junit.framework.Assert.assertEquals
import org.junit.Test

class DisplayTest {

    @Test
    fun notExistOperand_inputOperator_returnEmptyString() {
        val actual = Display.print(
            beforeText = "",
            operator = Operator.PLUS
        )
        assertEquals(actual, "")
    }

    @Test
    fun existOperand_inputOperator_returnOperandOperator() {
        val actual = Display.print(
            beforeText = "1",
            operator = Operator.PLUS
        )
        assertEquals(actual, "1+")
    }

    @Test
    fun existOperandAndOperator_inputOperator_returnOperandAndLatterOperator() {
        val actual = Display.print(
            beforeText = "1+",
            operator = Operator.MINUS
        )
        assertEquals(actual, "1-")
    }
}


