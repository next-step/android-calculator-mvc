package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Expect
import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.operand.Operator
import org.junit.Rule
import org.junit.Test

class OperatorTest {

    @get:Rule
    val expect: Expect = Expect.create()

    @Test
    fun `두개의 값을 더하면, 정상 값이 나와야한다`() {
        expect.that(Operator.PLUS.calculate(0.0, 0.0)).isEqualTo(0.0)
        expect.that(Operator.PLUS.calculate(5.0, 3.0)).isEqualTo(8.0)
        expect.that(Operator.PLUS.calculate(-3.0, 5.0)).isEqualTo(2.0)
        expect.that(Operator.PLUS.calculate(2.0, -3.0)).isEqualTo(-1.0)
    }

    @Test
    fun `두개의 값을 빼면, 정상 값이 나와야한다`() {
        expect.that(Operator.MINUS.calculate(0.0, 0.0)).isEqualTo(0.0)
        expect.that(Operator.MINUS.calculate(5.0, 3.0)).isEqualTo(2.0)
        expect.that(Operator.MINUS.calculate(-3.0, 5.0)).isEqualTo(-8.0)
        expect.that(Operator.MINUS.calculate(2.0, -3.0)).isEqualTo(5.0)
    }

    @Test
    fun `두개의 값을 곱하면, 정상 값이 나와야한다`() {
        expect.that(Operator.MULTIPLY.calculate(0.0, 0.0)).isEqualTo(0.0)
        expect.that(Operator.MULTIPLY.calculate(5.0, 0.0)).isEqualTo(0.0)
        expect.that(Operator.MULTIPLY.calculate(5.0, 3.0)).isEqualTo(15.0)
        expect.that(Operator.MULTIPLY.calculate(-3.0, 5.0)).isEqualTo(-15.0)
    }

    @Test
    fun `두개의 값을 나누면, 정상 값이 나와야한다`() {
        expect.that(Operator.DIVISION.calculate(0.0, 5.0)).isEqualTo(0.0)
        expect.that(Operator.DIVISION.calculate(5.0, 5.0)).isEqualTo(1.0)
        expect.that(Operator.DIVISION.calculate(-9.0, 3.0)).isEqualTo(-3.0)
        expect.that(Operator.DIVISION.calculate(81.0, 9.0)).isEqualTo(9.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `나누기일 경우, 나누는 값이 0이면, Exception을 던져한다`() {
        Operator.DIVISION.calculate(25.0, 0.0)
    }

    @Test
    fun `연산자 문자열을 입력하면, 유효한 연산자를 리턴한다`() {
        val operator = Operator.getOperator("/")
        assertThat(operator).isInstanceOf(Operator::class.java)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `연산자가 알수 없는 경우, Exception을 던져한다`() {
        Operator.getOperator("%")
    }
}
