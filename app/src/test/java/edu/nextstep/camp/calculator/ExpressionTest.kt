package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.Expression
import edu.nextstep.camp.calculator.domain.Validator
import org.junit.Before
import org.junit.Test

class ExpressionTest {

    private lateinit var expression: Expression
    private lateinit var validator: Validator

    @Before
    fun setUp() {
        validator = Validator()
        expression = Expression(validator = validator)
    }

    @Test
    fun 연산자_추가_테스트() {
        expression.addInputString("1")
        expression.addInputString("+")
        assertThat(expression.values).isEqualTo("1 + ")
    }

    @Test
    fun 제거_테스트() {
        expression.addInputString("1")
        expression.addInputString("+")
        expression.addInputString("2")
        expression.dropLast()
        assertThat(expression.values).isEqualTo("1 + ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun 잘못된_값_입력_테스트() {
        expression.addInputString("r")
    }

    @Test
    fun 연산자_중복_테스트() {
        expression.addInputString("1")
        expression.addInputString("+")
        expression.addInputString("+")
        assertThat(expression.values).isEqualTo("1 + ")
    }

    @Test
    fun 연산자_변경_테스트() {
        expression.addInputString("1")
        expression.addInputString("+")
        expression.addInputString("*")
        assertThat(expression.values).isEqualTo("1 * ")
    }

    @Test
    fun 마지막_값_버리기_테스트() {
        expression.addInputString("1")
        expression.addInputString("+")
        expression.dropLast()
        assertThat(expression.values).isEqualTo("1")
    }

    @Test(expected = IllegalArgumentException::class)
    fun 마지막_값_버리기_에러_테스트() {
        expression.dropLast()
        assertThat(expression.values).isEqualTo("1")
    }

    @Test
    fun 마지막_값_연산자_성공_테스트() {
        expression.addInputString("1")
        expression.addInputString("+")
        val actual = expression.isLastValueOperatorCheck()
        assertThat(actual).isTrue()
    }

    @Test
    fun 계산성공_테스트() {
        val actual = expression.complete("150")
        assertThat(actual).isEqualTo("150")
    }

}