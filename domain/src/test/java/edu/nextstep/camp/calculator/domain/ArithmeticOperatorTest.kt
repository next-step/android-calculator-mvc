package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.ArithmeticOperator.Companion.calculate
import edu.nextstep.camp.calculator.domain.ArithmeticOperator.Companion.convertToArithmeticOperation
import org.junit.Test

class ArithmeticOperatorTest {

    @Test
    fun stringConvertToPlus() {
        assertThat(convertToArithmeticOperation("+")).isEqualTo(ArithmeticOperator.PLUS)
    }

    @Test
    fun stringConvertToMinus() {
        assertThat(convertToArithmeticOperation("-")).isEqualTo(ArithmeticOperator.MINUS)
    }

    @Test
    fun stringConvertToMultiplication() {
        assertThat(convertToArithmeticOperation("*")).isEqualTo(ArithmeticOperator.MULTIPLICATION)
    }

    @Test
    fun stringConvertToDivision() {
        assertThat(convertToArithmeticOperation("/")).isEqualTo(ArithmeticOperator.DIVISION)
    }


    @Test
    fun calculatePlus() {
        val result = ArithmeticOperator.PLUS.calculate(1.0, 2.0)
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun calculateMinus() {
        val result = ArithmeticOperator.MINUS.calculate(3.0, 4.0)
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun calculateMultiplication() {
        val result = ArithmeticOperator.MULTIPLICATION.calculate(5.0, 6.0)
        assertThat(result).isEqualTo(30)
    }

    @Test
    fun calculateDivision() {
        val result = ArithmeticOperator.DIVISION.calculate(10.0, 8.0)
        assertThat(result).isEqualTo(1.25)
    }
}
