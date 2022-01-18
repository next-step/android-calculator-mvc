package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SingleOperationTest {

    @Test
    fun test_calculate_plus() {
        val result = SingleOperation(1.0, ArithmeticOperation.PLUS, 2.0).calculate()
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun test_calculate_minus() {
        val result = SingleOperation(3.0, ArithmeticOperation.MINUS, 4.0).calculate()
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun test_calculate_multiplication() {
        val result = SingleOperation(5.0, ArithmeticOperation.MULTIPLICATION, 6.0).calculate()
        assertThat(result).isEqualTo(30)
    }

    @Test
    fun test_calculate_division() {
        val result = SingleOperation(10.0, ArithmeticOperation.DIVISION, 8.0).calculate()
        assertThat(result).isEqualTo(1.25)
    }
}
