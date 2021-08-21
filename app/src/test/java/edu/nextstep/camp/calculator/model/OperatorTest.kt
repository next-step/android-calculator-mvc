package edu.nextstep.camp.calculator.model

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.jupiter.api.Test

class OperatorTest {
    private val firstOperand = 3.0
    private val secondOperand = 1.0

    @Test
    fun `덧셈을 해야한다`() {
        val result = Operator.PLUS.formula(firstOperand, secondOperand)
        assertThat(result, equalTo(4.0))
    }

    @Test
    fun `뺄샘을 해야한다`() {
        val result = Operator.MINUS.formula(firstOperand, secondOperand)
        assertThat(result, equalTo(2.0))
    }

    @Test
    fun `곱셈을 해야한다`() {
        val result = Operator.MULTIPLY.formula(firstOperand, secondOperand)
        assertThat(result, equalTo(3.0))
    }

    @Test
    fun `나눗셈을 해야한다`() {
        val result = Operator.DIVIDE.formula(firstOperand, secondOperand)
        assertThat(result, equalTo(3.0))
    }

    @Test
    fun `나눗셈을 해야한다 0으로 나눌 때 예외발생`() {
        assertThatThrownBy { Operator.DIVIDE.formula(firstOperand, 0.0) }
            .isInstanceOf(ArithmeticException::class.java)
            .hasMessageContaining("Divide by zero should trow")
    }
}