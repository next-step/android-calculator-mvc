package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.math.BigDecimal

@RunWith(Parameterized::class)
class OperatorTest(
    private val operator: String,
    private val firstOperand: BigDecimal,
    private val secondOperand: BigDecimal,
    private val result: BigDecimal
) {

    @Test
    fun 연산_테스트() {
        val operator = Operator.find(operator).calculate.invoke(firstOperand, secondOperand)

        assertThat(operator).isEqualTo(result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun parameterizedTestData() = listOf(
            arrayOf("+", BigDecimal(1), BigDecimal(1), BigDecimal(2)),
            arrayOf("-", BigDecimal(1), BigDecimal(1), BigDecimal(0)),
            arrayOf("*", BigDecimal(1), BigDecimal(1), BigDecimal(1)),
            arrayOf("/", BigDecimal(1), BigDecimal(1), BigDecimal(1)),
            arrayOf("/", BigDecimal(1), BigDecimal(0), BigDecimal(0)),
        )
    }

}