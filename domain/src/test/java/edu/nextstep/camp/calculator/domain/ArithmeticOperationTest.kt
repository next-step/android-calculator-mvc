package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.ArithmeticOperation.Companion.convertToArithmeticOperation
import org.junit.Test

class ArithmeticOperationTest {

    @Test
    fun stringConvertToPlus() {
        assertThat("+".convertToArithmeticOperation()).isEqualTo(ArithmeticOperation.PLUS)
    }

    @Test
    fun stringConvertToMinus() {
        assertThat("-".convertToArithmeticOperation()).isEqualTo(ArithmeticOperation.MINUS)
    }

    @Test
    fun stringConvertToMultiplication() {
        assertThat("*".convertToArithmeticOperation()).isEqualTo(ArithmeticOperation.MULTIPLICATION)
    }

    @Test
    fun stringConvertToDivision() {
        assertThat("/".convertToArithmeticOperation()).isEqualTo(ArithmeticOperation.DIVISION)
    }
}
