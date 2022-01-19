package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SingleOperationTest {

    @Test
    fun calculatePlus() {
        val result = SingleOperation(1.0, ArithmeticOperation.PLUS, 2.0).calculate()
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun calculateMinus() {
        val result = SingleOperation(3.0, ArithmeticOperation.MINUS, 4.0).calculate()
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun calculateMultiplication() {
        val result = SingleOperation(5.0, ArithmeticOperation.MULTIPLICATION, 6.0).calculate()
        assertThat(result).isEqualTo(30)
    }

    @Test
    fun calculateDivision() {
        val result = SingleOperation(10.0, ArithmeticOperation.DIVISION, 8.0).calculate()
        assertThat(result).isEqualTo(1.25)
    }
}
