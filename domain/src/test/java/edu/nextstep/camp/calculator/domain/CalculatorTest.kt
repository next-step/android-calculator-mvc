package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test

/**
 * Calculator 클래스 테스트
 * Created by jeongjinhong on 2022. 07. 17..
 */
class CalculatorTest {
    lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun Input이_Null_이거나_공백이면_IllegalArgumentException_throw() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluatesExpression(
                Expression()
            )
        }
    }

    @Test
    fun 사칙연산_기호가_아닌_경우_IllegalArgumentException_throw() {
        val expression = Expression().apply {
            addOperand(3)
            addOperator("~")
            addOperand(4)
        }
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluatesExpression(
                expression
            )
        }
    }

    @Test
    fun 피연산자들을_더하면_더한_값을_얻습니다() {
        val expression = Expression().apply {
            addOperand(3)
            addOperator("+")
            addOperand(4)
        }
        val result = calculator.evaluatesExpression(expression)
        assertThat(result).isEqualTo(3 + 4)
    }

    @Test
    fun 피연산자들을_빼면_뺀_값을_얻습니다() {
        val expression = Expression().apply {
            addOperand(3)
            addOperator("-")
            addOperand(4)
        }
        val result = calculator.evaluatesExpression(expression)
        assertThat(result).isEqualTo(3 - 4)
    }

    @Test
    fun 피연산자들을_나누면_나눈_값을_얻습니다() {
        val expression = Expression().apply {
            addOperand(3)
            addOperator("/")
            addOperand(4)
        }
        val result = calculator.evaluatesExpression(expression)
        assertThat(result).isEqualTo(3.0 / 4)
    }

    @Test
    fun 피연산자_0으로_나누면_IllegalArgumentException_throw() {
        val expression = Expression().apply {
            addOperand(3)
            addOperator("/")
            addOperand(0)
        }
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluatesExpression(
                expression
            )
        }
    }

    @Test
    fun 피연산자들을_곱하면_곱한_값을_얻습니다() {
        val expression = Expression().apply {
            addOperand(3)
            addOperator("*")
            addOperand(4)
        }
        val result = calculator.evaluatesExpression(expression)
        assertThat(result).isEqualTo(3 * 4)
    }

    @Test
    fun 모든_사칙연산을_포함한_식을_연산하면_연산된_값을_얻습니다() {
        val expression = Expression().apply {
            addOperand(2)
            addOperator("+")
            addOperand(3)
            addOperator("*")
            addOperand(4)
            addOperator("/")
            addOperand(2)
        }
        val result = calculator.evaluatesExpression(expression)
        assertThat(result).isEqualTo((2 + 3) * 4 / 2)
    }

}