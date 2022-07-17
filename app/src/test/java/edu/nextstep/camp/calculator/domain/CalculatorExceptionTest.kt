package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.math.BigDecimal

class CalculatorExceptionTest {

    private val calculator = Calculator(BlankSplitter(), Validator())

    @Test(expected = IllegalArgumentException::class)
    fun 공백_입력_테스트() {
        Truth.assertThat(calculator.evaluate("")).isEqualTo("")
    }


    @Test(expected = IllegalArgumentException::class)
    fun null_입력_테스트() {
        Truth.assertThat(calculator.evaluate(null)).isEqualTo("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun 사칙연산_기호가_아닌_다른_기호입력_테스트() {
        Truth.assertThat(calculator.evaluate("1 & 2")).isEqualTo("")
    }

}