package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Expect
import edu.nextstep.camp.calculator.domain.operand.Operator
import org.junit.Rule
import org.junit.Test

class StringConverterTest {

    @get:Rule
    val expect: Expect = Expect.create()

    private val converter = StringConverter(arrayOf("+", "-", "×", "÷"))

    @Test
    fun `연산식에서, 연산자와 피연산자를 분리한다`() {
        // given
        val expression = "33+22-11"
        // when
        val (operandList, operatorList) = converter.convert(expression)
        // then
        expect.that(operandList).isEqualTo(listOf(33.0, 22.0, 11.0))
        expect.that(operatorList).isEqualTo(
            listOf(
                Operator.getOperator("+"),
                Operator.getOperator("-")
            )
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun `올바르지 않은 연산식 입력시, 에러가 발생한다`() {
        // given
        val wrongExpression = "33+22--1"
        // when
        converter.convert(wrongExpression)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `연산식에 입력되지 않은 연산자가 있으면, 에러가 발생한다`() {
        // given : % 연산자
        val wrongOperatorExpression = "3+2-1%4"
        // when
        converter.convert(wrongOperatorExpression)
    }
}
