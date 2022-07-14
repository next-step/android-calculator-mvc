package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import org.junit.Test


class OperatorTest {

    @Test
    fun simpleAdditionBigNumber() {
        val actual: Int = Operator.ADDITION.evaluate(1073741823, 1073741824)
        Truth.assertThat(actual).isEqualTo(2147483647)
    }

    @Test
    fun simpleSubtraction() {
        val actual: Int = Operator.SUBTRACTION.evaluate(0, 5)
        Truth.assertThat(actual).isEqualTo(-5)
    }

    @Test
    fun simpleMultiplication() {
        val actual: Int = Operator.MULTIPLICATION.evaluate(12, 5)
        Truth.assertThat(actual).isEqualTo(60)
    }

    @Test
    fun simpleMultiplicationWithZero() {
        val actual: Int = Operator.MULTIPLICATION.evaluate(12, 0)
        Truth.assertThat(actual).isEqualTo(0)
    }

    @Test
    fun simpleDivision() {
        val actual: Int =  Operator.DIVISION.evaluate(12, 4)
        Truth.assertThat(actual).isEqualTo(3)
    }
}
