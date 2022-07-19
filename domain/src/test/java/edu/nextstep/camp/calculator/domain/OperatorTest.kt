package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class OperatorTest {

    @Test
    fun `사칙연산이 아니면 오류가 발생한다`() {
        // when
        val actual = Operator.find("!")
        // then
        assertThrows(IllegalArgumentException::class.java) { actual }
    }

    @Test
    fun `수식이 덧셈이면 덧셈 타입이 반환된다`() {
        // when
        val actual = Operator.find("+")
        // then
        assertThat(actual).isEqualTo(Operator.PLUS)
    }

    @Test
    fun `수식이 뺄셈이면 뺄셈 타입이 반환된다`() {
        // when
        val actual = Operator.find("-")
        // then
        assertThat(actual).isEqualTo(Operator.MINUS)
    }

    @Test
    fun `수식이 곱셈이면 곱셈 타입이 반환된다`() {
        // when
        val actual = Operator.find("*")
        // then
        assertThat(actual).isEqualTo(Operator.MULTIPLICATION)
    }

    @Test
    fun `수식이 나눗셈이면 나눗셈 타입이 반환된다`() {
        // when
        val actual = Operator.find("/")
        // then
        assertThat(actual).isEqualTo(Operator.DIVISION)
    }
}