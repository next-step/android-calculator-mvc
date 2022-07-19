package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import org.junit.Test

class ValidatorTest {

    private val validator = Validator()

    @Test
    fun 사칙연산_기호_테스트_알맞은_기호() {
        val actual = validator.isOperator("+")
        Truth.assertThat(actual).isTrue()
    }

    @Test
    fun 사칙연산_기호_테스트_다른_기호() {
        val actual = validator.isOperator("&")
        Truth.assertThat(actual).isFalse()
    }

    @Test
    fun 숫자_테스트() {
        val actual = validator.isNumeric("1")
        Truth.assertThat(actual).isTrue()
    }

    @Test(expected = IllegalArgumentException::class)
    fun 숫자_아닐_경우_테스트() {
        val actual = validator.isNumeric("ㅋ")
        Truth.assertThat(actual).isFalse()
    }

}