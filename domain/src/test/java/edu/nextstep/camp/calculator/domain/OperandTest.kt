package edu.nextstep.camp.calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Created by link.js on 2022. 07. 14..
 */
class OperandTest {
    @Test
    fun `Operand끼리 더했을때 정상적으로 더해진다`() {
        assertEquals(Operand(3) + Operand(3), Operand(6))
    }

    @Test
    fun `Operand끼리 뺐을때 정상적으로 빼진다`() {
        assertEquals(Operand(6) - Operand(3), Operand(3))
    }

    @Test
    fun `Operand끼리 곱했을때 정상적으로 곱해진다`() {
        assertEquals(Operand(3) * Operand(3), Operand(9))
    }

    @Test
    fun `Operand끼리 나눴을때 정상적으로 나눠진다`() {
        assertEquals(Operand(3) / Operand(3), Operand(1))
    }
}