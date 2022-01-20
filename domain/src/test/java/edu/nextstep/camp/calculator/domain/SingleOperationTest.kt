package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SingleOperationTest {

    @Test
    fun calculatePlus() {
        val result = SingleOperation.calculate(1.0, 2.0, ArithmeticOperator.PLUS)
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun calculateMinus() {
        val result = SingleOperation.calculate(3.0, 4.0, ArithmeticOperator.MINUS)
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun calculateMultiplication() {
        val result = SingleOperation.calculate(5.0, 6.0, ArithmeticOperator.MULTIPLICATION)
        assertThat(result).isEqualTo(30)
    }

    @Test
    fun calculateDivision() {
        val result = SingleOperation.calculate(10.0, 8.0, ArithmeticOperator.DIVISION)
        assertThat(result).isEqualTo(1.25)
    }
}
