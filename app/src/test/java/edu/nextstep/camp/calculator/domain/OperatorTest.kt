package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import org.junit.Test
import java.math.BigDecimal

class OperatorTest {

    @Test
    fun 덧셈_테스트() {
        val operator = Operator.find("+")?.calculate?.invoke(BigDecimal(1), BigDecimal(1))

        Truth.assertThat(operator).isEqualTo(BigDecimal(2))
    }

    @Test
    fun 뺄셈_테스트() {
        val operator = Operator.find("-")?.calculate?.invoke(BigDecimal(1), BigDecimal(1))

        Truth.assertThat(operator).isEqualTo(BigDecimal(0))
    }

    @Test
    fun 곱셈_테스트() {
        val operator = Operator.find("*")?.calculate?.invoke(BigDecimal(1), BigDecimal(1))

        Truth.assertThat(operator).isEqualTo(BigDecimal(1))
    }

    @Test
    fun 나눗셈_테스트() {
        val operator = Operator.find("/")?.calculate?.invoke(BigDecimal(1), BigDecimal(1))

        Truth.assertThat(operator).isEqualTo(BigDecimal(1))
    }

    @Test
    fun 나눗셈_0_값_테스트() {
        val operator = Operator.find("/")?.calculate?.invoke(BigDecimal(1), BigDecimal(0))

        Truth.assertThat(operator).isEqualTo(BigDecimal(0))
    }

}