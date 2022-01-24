package net.woogear.domain

import junit.framework.Assert.assertEquals
import org.junit.Test

class FormulaManagerTest {
    @Test
    fun `아무것도 입력하지 않은 상태에서 input("+")를 실행하면 그대로이다`() {
        // given
        val formulaManager = FormulaManager()
        //when
        val result = formulaManager.input("+")
        // then
        assertEquals("", result)
    }

    @Test
    fun `11 * 에 input("5")를 실행하면 11 * 5 이다`() {
        val formulaManager = FormulaManager("11 *")
        val result = formulaManager.input("5")
        assertEquals("11 * 5", result)
    }

    @Test
    fun `10 나누기 5 곱하기는 완성되지 않은 수식이다`() {
        // given
        val formulaManager = FormulaManager("10 / 5 *")
        //when
        val isCompleted = formulaManager.isFormulaCompleted()
        // then
        assertEquals(false, isCompleted)
    }

    @Test
    fun `5 더하기 11 나누기 8은 완성된 수식이다`() {
        // given
        val formulaManager = FormulaManager("5 + 11 / 8")
        //when
        val isCompleted = formulaManager.isFormulaCompleted()
        // then
        assertEquals(true, isCompleted)
    }

    @Test
    fun `10 빼기 6에 delete()을 실행하면 10 빼기 이다`() {
        // given
        val formulaManager = FormulaManager("10 - 6")

        //when
        val result = formulaManager.delete()

        // then
        assertEquals("10 -", result)
    }
}