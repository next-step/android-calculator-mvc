package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.ArithmeticOperator.Companion.calculate
import edu.nextstep.camp.calculator.domain.ArithmeticOperator.Companion.convertToArithmeticOperation
import org.junit.Test

class ArithmeticOperatorTest {

    @Test
    fun stringConvertToPlus() {
        //given
        val content = "+"

        //when
        val result = convertToArithmeticOperation(content)

        //then
        assertThat(result).isEqualTo(ArithmeticOperator.PLUS)
    }

    @Test
    fun stringConvertToMinus() {
        //given
        val content = "-"

        //when
        val result = convertToArithmeticOperation(content)

        //then
        assertThat(result).isEqualTo(ArithmeticOperator.MINUS)
    }

    @Test
    fun stringConvertToMultiplication() {
        //given
        val content = "×"

        //when
        val result = convertToArithmeticOperation(content)

        //then
        assertThat(result).isEqualTo(ArithmeticOperator.MULTIPLICATION)
    }

    @Test
    fun stringConvertToDivision() {
        //given
        val content = "÷"

        //when
        val result = convertToArithmeticOperation(content)

        //then
        assertThat(result).isEqualTo(ArithmeticOperator.DIVISION)
    }


    @Test
    fun calculatePlus() {
        //given
        val firstOperand = 1.0
        val secondOperand = 2.0
        val operator = ArithmeticOperator.PLUS

        //when
        val result = operator.calculate(firstOperand, secondOperand)

        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun calculateMinus() {
        //given
        val firstOperand = 3.0
        val secondOperand = 4.0
        val operator = ArithmeticOperator.MINUS

        //when
        val result = operator.calculate(firstOperand, secondOperand)

        //then
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun calculateMultiplication() {
        //given
        val firstOperand = 5.0
        val secondOperand = 6.0
        val operator = ArithmeticOperator.MULTIPLICATION

        //when
        val result = operator.calculate(firstOperand, secondOperand)

        //then
        assertThat(result).isEqualTo(30)
    }

    @Test
    fun calculateDivision() {
        //given
        val firstOperand = 10.0
        val secondOperand = 8.0
        val operator = ArithmeticOperator.DIVISION

        //when
        val result = operator.calculate(firstOperand, secondOperand)

        //then
        assertThat(result).isEqualTo(1.25)
    }
}
