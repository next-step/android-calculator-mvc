package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SingleOperationTest {

    @Test
    fun calculatePlus() {
        val result = SingleOperation.calculate(1.0, 2.0, ArithmeticOperation.PLUS)
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun calculateMinus() {
        val result = SingleOperation.calculate(3.0, 4.0, ArithmeticOperation.MINUS)
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun calculateMultiplication() {
        val result = SingleOperation.calculate(5.0, 6.0, ArithmeticOperation.MULTIPLICATION)
        assertThat(result).isEqualTo(30)
    }

    @Test
    fun calculateDivision() {
        val result = SingleOperation.calculate(10.0, 8.0, ArithmeticOperation.DIVISION)
        assertThat(result).isEqualTo(1.25)
    }
}
