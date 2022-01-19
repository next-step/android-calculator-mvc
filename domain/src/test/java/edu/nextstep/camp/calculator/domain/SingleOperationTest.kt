package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SingleOperationTest {

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
}
