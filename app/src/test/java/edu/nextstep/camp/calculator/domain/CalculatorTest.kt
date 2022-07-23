package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.math.BigDecimal

@RunWith(Parameterized::class)
class CalculatorTest(
    private val inputString: String,
    private val result: BigDecimal
) {

    private lateinit var blankSplitter: BlankSplitter
    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        blankSplitter = BlankSplitter()
        calculator = Calculator(blankSplitter)
    }

    @Test
    fun 계산기_기능_테스트() {
        assertThat(calculator.evaluate(inputString)).isEqualTo(result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun parameterizedTestData() = listOf(
            arrayOf("1 + 2 + 3", BigDecimal(6)),
            arrayOf("1 - 2 + 3", BigDecimal(2)),
            arrayOf("1 * 2 + 3", BigDecimal(5)),
            arrayOf("1 * 2 - 3", BigDecimal(-1)),
            arrayOf("6 / 2 + 3", BigDecimal(6)),
            arrayOf("6 / 2 - 3", BigDecimal(0)),
            arrayOf("5 * 2 / 2", BigDecimal(5)),
            arrayOf("1 / 0 + 3", BigDecimal(3)),
            arrayOf("5 + 4 - 3 * 2 / 2", BigDecimal(6)),
        )
    }

}

class CalculatorExceptionTest {

    private lateinit var blankSplitter: BlankSplitter
    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        blankSplitter = BlankSplitter()
        calculator = Calculator(blankSplitter)
    }

    @Test(expected = IllegalArgumentException::class)
    fun 공백_입력_테스트() {
        assertThat(calculator.evaluate("")).isEqualTo("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun 사칙연산_기호가_아닌_다른_기호입력_테스트() {
        assertThat(calculator.evaluate("1 & 2")).isEqualTo("")
    }

}