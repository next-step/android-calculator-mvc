package edu.nextstep.camp.calculator.domain

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
    fun 숫자_입력_후_연산자_추가_테스트() {
        expression += "1"
        expression += " + "
        assertThat(expression.toString()).isEqualTo("1 + ")
    }

    @Test
    fun 숫자_연산자_숫자_입력_후_마지막_문자_제거_테스트() {
        expression += "1"
        expression += " + "
        expression += "2"
        expression = expression.dropLast()
        assertThat(expression.toString()).isEqualTo("1 + ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun 잘못된_값_입력_테스트() {
        expression += "r"
    }

    @Test
    fun 마지막_연산자가_현재_입력한_연산자와_중복일_경우_테스트() {
        expression += "1"
        expression += " + "
        expression += " + "
        assertThat(expression.toString()).isEqualTo("1 + ")
    }

    @Test
    fun 마지막_문자열이_연산자인_경우_다른_연산자_입력_시_연산자_변경_테스트() {
        expression += "1"
        expression += " + "
        expression += " * "
        assertThat(expression.toString()).isEqualTo("1 * ")
    }

    @Test
    fun 마지막_값_연산자_성공_테스트() {
        expression += "1"
        expression += " + "
        val actual = expression.isLastValueOperatorCheck()
        assertThat(actual).isTrue()
    }

}