package edu.nextstep.camp.calculator.domain.validator

import com.google.common.truth.Truth
import org.junit.Test


class CalculatorValidatorTest {
    @Test(expected = IllegalArgumentException::class)
    fun `사칙연산이_아닌_특수문자를_입력하면_IllegalArgumentException_에러를_낸다`() {
        CalculatorInputValidator.isValidOperationMark("1 a 2 * 1")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `빈문자열을_입력하면_IllegalArgumentException_에러를_낸다`() {
        CalculatorInputValidator.checkIsInputEmpty("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `공백을_입력하면_IllegalArgumentException_에러를_낸다`() {
        CalculatorInputValidator.checkIsInputEmpty(" ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `계산이_불가능한_문자로_구성된_배열을_전달하면_에러를_낸다`() {
        CalculatorInputValidator.checkIsArrContainValidOperator(listOf("a", "1"))
    }

    @Test
    fun `계산이_가능한_문자로_구성된_배열을_전달하면_TRUE를_리턴한다`() {
        val actual = CalculatorInputValidator.checkIsArrContainValidOperator(listOf("-", "1"))
        Truth.assertThat(actual).isEqualTo(true)
    }
}