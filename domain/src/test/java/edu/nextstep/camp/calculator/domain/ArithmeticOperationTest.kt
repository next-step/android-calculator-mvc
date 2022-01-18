package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.ArithmeticOperation.Companion.convertToArithmeticOperation
import org.junit.Test

class ArithmeticOperationTest {

    @Test
    fun test_string_convert_to_plus() {
        assertThat("+".convertToArithmeticOperation()).isEqualTo(ArithmeticOperation.PLUS)
    }

    @Test
    fun test_string_convert_to_minus() {
        assertThat("-".convertToArithmeticOperation()).isEqualTo(ArithmeticOperation.MINUS)
    }

    @Test
    fun test_string_convert_to_multiplication() {
        assertThat("*".convertToArithmeticOperation()).isEqualTo(ArithmeticOperation.MULTIPLICATION)
    }

    @Test
    fun test_string_convert_to_division() {
        assertThat("/".convertToArithmeticOperation()).isEqualTo(ArithmeticOperation.DIVISION)
    }
}
