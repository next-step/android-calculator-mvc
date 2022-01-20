package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
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
}
