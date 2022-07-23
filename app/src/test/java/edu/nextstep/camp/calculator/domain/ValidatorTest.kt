package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ValidatorTest(
    private val inputString: String,
    private val isResult: Boolean
) {

    private val validator = Validator()

    @Test
    fun 사칙연산_기호_테스트_알맞은_기호() {
        val actual = validator.isOperator(inputString)
        assertThat(actual).isEqualTo(isResult)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun parameterizedTestData() = listOf(
            arrayOf("+", true),
            arrayOf("-", true),
            arrayOf("*", true),
            arrayOf("/", true),
            arrayOf("ㅇ", false),
        )
    }

}

class ValidatorExceptionText {

    private val validator = Validator()

    @Test
    fun 숫자_테스트() {
        val actual = validator.isNumeric("3")
        assertThat(actual).isTrue()
    }

    @Test(expected = IllegalArgumentException::class)
    fun 숫자_아닐_경우_테스트() {
        val actual = validator.isNumeric("ㅇ")
        assertThat(actual).isFalse()
    }

}