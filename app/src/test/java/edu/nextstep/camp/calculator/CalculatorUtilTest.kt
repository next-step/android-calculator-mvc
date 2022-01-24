package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.Assert
import org.junit.Test

class CalculatorUtilTest {

    private val calculatorUtil = CalculatorUtil()

    @Test
    fun `given complete formula when equals then get result`() {
        //given
        calculatorUtil.addText("27+73")

        //when
        calculatorUtil.equals()

        //then
        assertThat(calculatorUtil.result).isEqualTo("100")
    }

    @Test
    fun `given incomplete formula when equals then show error`() {
        //then
        val result = Assert.assertThrows(IllegalArgumentException::class.java) {
            //given
            calculatorUtil.addText("27+73-")

            //when
            calculatorUtil.equals()
        }
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
    }
}