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
        val content = "*"

        //when
        val result = convertToArithmeticOperation(content)

        //then
        assertThat(result).isEqualTo(ArithmeticOperator.MULTIPLICATION)
    }

    @Test
    fun stringConvertToDivision() {
        //given
        val content = "/"

        //when
        val result = convertToArithmeticOperation(content)

        //then
        assertThat(result).isEqualTo(ArithmeticOperator.DIVISION)
    }


    @Test
    fun calculatePlus() {
        //given
        val firstNumber = 1.0
        val secondNumber = 2.0
        val operator = ArithmeticOperator.PLUS

        //when
        val result = operator.calculate(firstNumber, secondNumber)

        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun calculateMinus() {
        //given
        val firstNumber = 3.0
        val secondNumber = 4.0
        val operator = ArithmeticOperator.MINUS

        //when
        val result = operator.calculate(firstNumber, secondNumber)

        //then
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun calculateMultiplication() {
        //given
        val firstNumber = 5.0
        val secondNumber = 6.0
        val operator = ArithmeticOperator.MULTIPLICATION

        //when
        val result = operator.calculate(firstNumber, secondNumber)

        //then
        assertThat(result).isEqualTo(30)
    }

    @Test
    fun calculateDivision() {
        //given
        val firstNumber = 10.0
        val secondNumber = 8.0
        val operator = ArithmeticOperator.DIVISION

        //when
        val result = operator.calculate(firstNumber, secondNumber)

        //then
        assertThat(result).isEqualTo(1.25)
    }
}
