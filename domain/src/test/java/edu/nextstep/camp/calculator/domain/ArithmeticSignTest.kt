package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.ArithmeticSign.Companion.calculate
import edu.nextstep.camp.calculator.domain.ArithmeticSign.Companion.convertToArithmeticOperation
import org.junit.Test

class ArithmeticSignTest {

    @Test
    fun stringConvertToPlus() {
        //given
        val content = "+"

        //when
        val result = convertToArithmeticOperation(content)

        //then
        assertThat(result).isEqualTo(ArithmeticSign.PLUS)
    }

    @Test
    fun stringConvertToMinus() {
        //given
        val content = "-"

        //when
        val result = convertToArithmeticOperation(content)

        //then
        assertThat(result).isEqualTo(ArithmeticSign.MINUS)
    }

    @Test
    fun stringConvertToMultiplication() {
        //given
        val content = "×"

        //when
        val result = convertToArithmeticOperation(content)

        //then
        assertThat(result).isEqualTo(ArithmeticSign.MULTIPLICATION)
    }

    @Test
    fun stringConvertToDivision() {
        //given
        val content = "÷"

        //when
        val result = convertToArithmeticOperation(content)

        //then
        assertThat(result).isEqualTo(ArithmeticSign.DIVISION)
    }


    @Test
    fun calculatePlus() {
        //given
        val firstOperand = 1.0
        val secondOperand = 2.0
        val sign = ArithmeticSign.PLUS

        //when
        val result = sign.calculate(firstOperand, secondOperand)

        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun calculateMinus() {
        //given
        val firstOperand = 3.0
        val secondOperand = 4.0
        val sign = ArithmeticSign.MINUS

        //when
        val result = sign.calculate(firstOperand, secondOperand)

        //then
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun calculateMultiplication() {
        //given
        val firstOperand = 5.0
        val secondOperand = 6.0
        val sign = ArithmeticSign.MULTIPLICATION

        //when
        val result = sign.calculate(firstOperand, secondOperand)

        //then
        assertThat(result).isEqualTo(30)
    }

    @Test
    fun calculateDivision() {
        //given
        val firstOperand = 10.0
        val secondOperand = 8.0
        val sign = ArithmeticSign.DIVISION

        //when
        val result = sign.calculate(firstOperand, secondOperand)

        //then
        assertThat(result).isEqualTo(1.25)
    }
}
