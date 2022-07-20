package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.*
import edu.nextstep.camp.calculator.domain.model.Operand
import edu.nextstep.camp.calculator.domain.model.Operator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class OperatorTest {

    @ParameterizedTest(name = "#{index}) {0} + {1} == {2}")
    @CsvSource(
        "1, 2, 3",
        "100, 12, 112",
        "1073741823, 1073741824, 2147483647",
    )
    fun addition(firstOperand: Int, secondOperand: Int, expected: Int) {
        val actual: Int = Operator.ADDITION.evaluate(Operand(firstOperand), Operand(secondOperand)).value
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "#{index}) {0} - {1} == {2}")
    @CsvSource(
        "4, 2, 2",
        "0, 0, 0",
        "0, 1073741824, -1073741824",
    )
    fun subtraction(firstOperand: Int, secondOperand: Int, expected: Int) {
        val actual: Int = Operator.SUBTRACTION.evaluate(Operand(firstOperand), Operand(secondOperand)).value
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "#{index}) {0} * {1} == {2}")
    @CsvSource(
        "4, 2, 8",
        "0, 0, 0",
        "0, 1073741824, 0",
        "-5, 4, -20",
        "-1, -1, 1"
    )
    fun multiplication(firstOperand: Int, secondOperand: Int, expected: Int) {
        val actual: Int = Operator.MULTIPLICATION.evaluate(Operand(firstOperand), Operand(secondOperand)).value
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "#{index}) {0} ÷ {1} == {2}")
    @CsvSource(
        "4, 2, 2",
        "1, 3, 0",
        "2, 2, 1",
    )
    fun division(firstOperand: Int, secondOperand: Int, expected: Int) {
        val actual: Int = Operator.DIVISION.evaluate(Operand(firstOperand), Operand(secondOperand)).value
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun divideByZero_ThrowArithmeticException() {
        assertThrows<ArithmeticException> { Operator.DIVISION.evaluate(Operand(3), Operand(0)) }
    }
}
