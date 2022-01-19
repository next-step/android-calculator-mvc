package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.assertj.core.api.Assertions
import org.junit.Test

class SingleOperationTest {

    @Test
    fun addOperationContents() {
        val singleOperation = SingleOperation()
        assertThat(singleOperation.isCalculationOrder()).isFalse()
        singleOperation.addOperationContent("1")
        assertThat(singleOperation.isCalculationOrder()).isFalse()
        singleOperation.addOperationContent("+")
        assertThat(singleOperation.isCalculationOrder()).isFalse()
        singleOperation.addOperationContent("2")
        assertThat(singleOperation.isCalculationOrder()).isTrue()
        singleOperation.calculate()
        assertThat(singleOperation.isCalculationOrder()).isFalse()
    }

    @Test
    fun addOperationContentInWrongOrder() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            val singleOperation = SingleOperation()
            singleOperation.addOperationContent("1")
            singleOperation.addOperationContent("+")
            singleOperation.addOperationContent("2")
            singleOperation.addOperationContent("+")
        }
    }

    @Test
    fun calculatePlus() {
        val singleOperation = SingleOperation()
        singleOperation.addOperationContent("1")
        singleOperation.addOperationContent("+")
        singleOperation.addOperationContent("2")
        val result = singleOperation.calculate()
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun calculateMinus() {
        val singleOperation = SingleOperation()
        singleOperation.addOperationContent("3")
        singleOperation.addOperationContent("-")
        singleOperation.addOperationContent("4")
        val result = singleOperation.calculate()
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun calculateMultiplication() {
        val singleOperation = SingleOperation()
        singleOperation.addOperationContent("5")
        singleOperation.addOperationContent("*")
        singleOperation.addOperationContent("6")
        val result = singleOperation.calculate()
        assertThat(result).isEqualTo(30)
    }

    @Test
    fun calculateDivision() {
        val singleOperation = SingleOperation()
        singleOperation.addOperationContent("10")
        singleOperation.addOperationContent("/")
        singleOperation.addOperationContent("8")
        val result = singleOperation.calculate()
        assertThat(result).isEqualTo(1.25)
    }

    @Test
    fun calculateWrongCalculationOrder() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            val singleOperation = SingleOperation()
            singleOperation.addOperationContent("10")
            singleOperation.addOperationContent("/")
            singleOperation.calculate()
        }
    }

    @Test
    fun isCalculationOrderTrue() {
        val singleOperation = SingleOperation()
        singleOperation.addOperationContent("1")
        singleOperation.addOperationContent("+")
        singleOperation.addOperationContent("2")
        assertThat(singleOperation.isCalculationOrder()).isTrue()
    }

    @Test
    fun isCalculationOrderFalse() {
        val singleOperation = SingleOperation()
        singleOperation.addOperationContent("1")
        singleOperation.addOperationContent("+")
        assertThat(singleOperation.isCalculationOrder()).isFalse()
    }
}
