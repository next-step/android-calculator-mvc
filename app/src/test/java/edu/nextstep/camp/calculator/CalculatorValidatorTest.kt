package edu.nextstep.camp.calculator

import com.soolee.domain.validator.CalculatorInputValidator
import org.junit.Test

class CalculatorValidatorTest {
    @Test(expected = IllegalArgumentException::class)
    fun `사칙연산이_아닌_특수문자를_입력하면_IllegalArgumentException_에러를_낸다`() {
        CalculatorInputValidator.isValidOperationMark("1 a 2 * 1")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `빈문자열을_입력하면_IllegalArgumentException_에러를_낸다`() {
        CalculatorInputValidator.isValueNotEmpty("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `공백을_입력하면_IllegalArgumentException_에러를_낸다`() {
        CalculatorInputValidator.isValueNotEmpty(" ")
    }
}